package com.example.examenuf2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private ImageView imagenGrande;
    private TextView titulo;
    private TextView fecha;
    private TextView desc;
    private TextView content;
    private TextView author;
    private Button webButton;
    private Button authorButton;
    private Button contactButton;
    private ViewPager viewPager;
    private YouTubePlayerView youTubePlayerView;
    private RecyclerView recylerComentarios;


    private List<Article> arrayArticle = new ArrayList<>();
    private AdapterComentarios commentAdapter;
    private ImageAdapter imageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //hook
        imagenGrande = findViewById(R.id.imagenGrandeDetails);
        titulo = findViewById(R.id.tituloDetails);
        fecha = findViewById(R.id.fechaDetails);
        desc = findViewById(R.id.descDetails);
        content = findViewById(R.id.contentDetails);
        author = findViewById(R.id.authorDetails);
        webButton = findViewById(R.id.webButton);
        authorButton = findViewById(R.id.authorButton);
        contactButton = findViewById(R.id.contactButton);
        viewPager = findViewById(R.id.viewPager);
        youTubePlayerView = findViewById(R.id.youTubePlayerView);
        recylerComentarios = findViewById(R.id.recylerComentarios);

        Intent intent = getIntent();

        recuperarArticles(intent.getStringExtra("nombre"));
    }

    private void recuperarArticles(String nombre) {


        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest reques = new JsonObjectRequest(
                Request.Method.GET,
                MainActivity.urlJSON,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {


                        String status = response.optString("status");//optString es que puede estar o no?
                        String num_results = response.optString("totalResults");


                        if (status.equals("ok") && Integer.parseInt(num_results) != 0) {//la web se ha cargado bien y hay resultados
                            JSONArray jsonArray = response.optJSONArray("articles");//recuperar array


                            if (jsonArray != null) {
                                for (int contador = 0; contador < jsonArray.length(); contador++) {
                                    try {
                                        JSONObject objetos = jsonArray.getJSONObject(contador);

                                        if (objetos.optString("title").equals(nombre)) {//recuperas el que hacen click

                                            Picasso.get()
                                                    .load(objetos.optString("urlToImage"))
                                                    .fit().centerCrop().into(imagenGrande);
                                            titulo.setText(objetos.optString("title"));
                                            fecha.setText(objetos.optString("publishedAt"));
                                            desc.setText(objetos.optString("description"));
                                            content.setText(objetos.optString("content"));
                                            author.setText(objetos.optString("authorname"));


                                            //---------
                                            //botones
                                            webButton.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {

                                                    Uri uri = Uri.parse(objetos.optString("url"));
                                                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                    startActivity(intent);
                                                }
                                            });

                                            authorButton.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {

                                                    Uri uri = Uri.parse(objetos.optString("authorlink"));
                                                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                    startActivity(intent);
                                                }
                                            });


                                            //email
                                            contactButton.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intentEmail = new Intent(Intent.ACTION_SEND);
                                                    String[] emailTO = {objetos.optString("contact")};
                                                    intentEmail.setData(Uri.parse("mailto:"));
                                                    intentEmail.setType("text/plain");

                                                    intentEmail.putExtra(Intent.EXTRA_EMAIL, emailTO);
                                                    intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Subject of the mail");
                                                    intentEmail.putExtra(Intent.EXTRA_TEXT, "This is the text to send with the mail");

                                                    try {
                                                        startActivity(Intent.createChooser(intentEmail, "Send mail..."));
                                                    } catch (android.content.ActivityNotFoundException ex) {
                                                        Toast.makeText(DetailActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });


                                            //--------------
                                            //pageSlider
                                            JSONObject arraymedia = objetos.optJSONObject("media");//recuperas obj de obj

                                            Gson gson = new Gson();
                                            MediaJSON mediaJSON = new MediaJSON();
                                            mediaJSON = gson.fromJson(arraymedia.toString(), MediaJSON.class);//casteo

                                            List<String> imgs = new ArrayList<>();
                                            imgs.add(mediaJSON.getUrlToImage1());
                                            imgs.add(mediaJSON.getUrlToImage2());
                                            imgs.add(mediaJSON.getUrlToImage3());


                                            imageAdapter = new ImageAdapter(getApplicationContext(), imgs);
                                            viewPager.setAdapter(imageAdapter);

                                            //----------
                                            //video

                                            getLifecycle().addObserver(youTubePlayerView);
                                            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                                                @Override
                                                public void onReady(YouTubePlayer youTubePlayer) {
                                                    String urlOriginal = objetos.optString("urlvideo");
                                                    String[] cortado = urlOriginal.split("/embed/");

                                                    youTubePlayer.cueVideo(cortado[1], 0);//loadVideo>al salir en la pantalla se reproduce
                                                    //cueVideo>Al aprecer se queda en cola hasta que le apretas play
                                                }
                                            });

                                            //----------
                                            //comentarios
                                            JSONArray arrayComentarios = objetos.optJSONArray("comments");//recuperas array de obj

                                            List<String> comentariosLista = new ArrayList<>();

                                            for (int contador2 = 0; contador2 < arrayComentarios.length(); contador2++) {
                                                comentariosLista.add(arrayComentarios.getString(contador2));
                                            }

                                            commentAdapter = new AdapterComentarios(getApplicationContext(), comentariosLista);
                                            recylerComentarios.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                            recylerComentarios.setAdapter(commentAdapter);

                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }


                                }
//                                arrayArticle = Arrays.asList(new GsonBuilder().create().fromJson(jsonArray.toString(), Article[].class));


                            }

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Error leyendo datos", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        queue.add(reques);
    }
}