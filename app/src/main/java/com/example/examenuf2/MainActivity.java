package com.example.examenuf2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String urlJSON = "https://run.mocky.io/v3/39fcc41e-9d03-486c-8fb2-235e3e831a1b";

    private ImageView imagen;
    private RecyclerView recyclerView;

    private List<Article> arrayArticle = new ArrayList<>();
    private AdapterArticles adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hooks
        imagen = findViewById(R.id.marvelImagen);
        recyclerView = findViewById(R.id.recyclerMain);


        //imagen logo
        Picasso.get()
                .load("https://1000marcas.net/wp-content/uploads/2020/02/Marvel-Studios-Logo-2002.png")
                .fit().centerCrop().into(imagen);

        recuperarArticles();
    }

    private void recuperarArticles() {


        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest reques = new JsonObjectRequest(
                Request.Method.GET,
                urlJSON,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {


                        String status = response.optString("status");//optString es que puede estar o no?
                        String num_results = response.optString("totalResults");


                        if (status.equals("ok") && Integer.parseInt(num_results) != 0) {//la web se ha cargado bien y hay resultados
                            JSONArray jsonArray = response.optJSONArray("articles");//recuperar array


                            if (jsonArray != null) {
                                arrayArticle = Arrays.asList(new GsonBuilder().create().fromJson(jsonArray.toString(), Article[].class));

                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                adapter = new AdapterArticles(MainActivity.this, arrayArticle);
                                recyclerView.setAdapter(adapter);
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