package com.example.newyorkapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivityMovie extends AppCompatActivity {

    private ImageView imagen;
    private TextView titulo;
    private TextView headline;
    private TextView desc;
    private TextView publication;
    private TextView opening;
    private TextView update;
    private Button web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        imagen=findViewById(R.id.imageDetail);
        titulo=findViewById(R.id.tituloDetail);
        headline=findViewById(R.id.headlineDetail);
        desc=findViewById(R.id.DescDetail);
        publication=findViewById(R.id.publication);
        opening=findViewById(R.id.opening);
        update=findViewById(R.id.dateUpdate);
        web=findViewById(R.id.webDetail);

        Intent intent=getIntent();

        if(intent.getStringExtra("img")!=null){
            Picasso.get().load(intent.getStringExtra("img")).fit().centerInside().into(imagen);
        }
        else{
            imagen.setImageResource(R.drawable.nytlogo_placeholder);
        }
        titulo.setText(intent.getStringExtra("titulo"));
        headline.setText(intent.getStringExtra("headline"));
        desc.setText(intent.getStringExtra("desc"));
        publication.setText(intent.getStringExtra("pub"));
        opening.setText(intent.getStringExtra("op"));
        update.setText(intent.getStringExtra("up"));


        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri=Uri.parse(intent.getStringExtra("link"));
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
}
        });

    }
}