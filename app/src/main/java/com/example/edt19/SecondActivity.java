package com.example.edt19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private ImageView imagenBG;
    private ImageView imagenIcono;
    private LinearLayout textoIcono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imagenBG=findViewById(R.id.imagenBG2);
        imagenIcono=findViewById(R.id.iconoBici2);
        textoIcono=findViewById(R.id.textoIcono2);
    }
}