package com.example.floatingmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    private ImageView icono;
    private ImageView imagenGrande;
    private TextView tit1;
    private TextView tit2;
    private TextView tit3;
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        icono=findViewById(R.id.detailsIcono);
        imagenGrande=findViewById(R.id.detailsImgGrande);
        tit1=findViewById(R.id.detailsTit1);
        tit2=findViewById(R.id.detailsTit2);
        tit3=findViewById(R.id.detailsTit3);
        desc=findViewById(R.id.detailsDesc);

        //recuperar
        Intent i=getIntent();
        String titulo1Recuperada=i.getStringExtra("tit1");
        String titulo2Recuperada=i.getStringExtra("tit2");
        String titulo3Recuperada=i.getStringExtra("tit3");
        String descripcionRecuperada=i.getStringExtra("desc");
        int iconoRecuperado=i.getIntExtra("icono",1);
        int imgGrandeRecuperado=i.getIntExtra("imgGrande",1);


        //poner en su sitio
        desc.setText(descripcionRecuperada);
        tit1.setText(titulo1Recuperada);
        tit2.setText(titulo2Recuperada);
        tit3.setText(titulo3Recuperada);

        icono.setImageResource(iconoRecuperado);
        imagenGrande.setImageResource(imgGrandeRecuperado);



    }
}