package com.example.edt36;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SportAdapter adapter;
    private List<Sports> sportsList = new ArrayList<>();


    public static String JSON_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        recyclerView = findViewById(R.id.recyclerDetail);

        Intent intent = getIntent();
        String pais = intent.getStringExtra("pais");
        JSON_URL = "https://www.thesportsdb.com/api/v1/json/2/search_all_leagues.php?c=" + pais;


        initJSON_Data();


    }

    private void initJSON_Data() {
        RequestQueue queue = Volley.newRequestQueue(this);


        JsonObjectRequest requestCountry = new JsonObjectRequest(//es un objeto con una array dentro
                Request.Method.GET,
                JSON_URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray arrayCountry = response.getJSONArray("countrys");
                            for (int contador = 0; contador < arrayCountry.length(); contador++) {

                                JSONObject objetos = arrayCountry.getJSONObject(contador);

                                Sports sports = new Sports();

                                sports.setFlagUrl(objetos.getString("strBadge"));
                                sports.setTextTitle(objetos.getString("strLeague"));
                                sports.setTextDescription(objetos.getString("strDescriptionEN"));
                                sports.setWeb(objetos.getString("strWebsite"));

                                List<String> imagenes=new ArrayList<>();
                                String img1=objetos.getString("strFanart1");
                                String img2=objetos.getString("strFanart2");
                                String img3=objetos.getString("strFanart3");
                                String img4=objetos.getString("strFanart4");
                                imagenes.add(img1);
                                imagenes.add(img2);
                                imagenes.add(img3);
                                imagenes.add(img4);

                                sports.setImagens(imagenes);


                                sportsList.add(sports);


                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        adapter = new SportAdapter(getApplicationContext(), sportsList);
                        recyclerView.setAdapter(adapter);


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(getApplicationContext(), "Error leyendo datos", Toast.LENGTH_SHORT).show();
                    }
                }
        );


        queue.add(requestCountry);
    }
}