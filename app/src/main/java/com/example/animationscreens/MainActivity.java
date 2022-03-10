package com.example.animationscreens;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable animationDrawable;
    private ImageView imagen;
    private TextView texto;
    public static final int delay=2000;
    //poner que la action rara superior sea del mismo color que el primero
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTheme(R.style.Theme_AnimationScreens_Main1);

        //V1
        //solo una imagen
        //setBackground a la imagen del xml de animation_lista
        //animation.setBackground(imagen)
        texto=findViewById(R.id.textMain1);
        imagen =findViewById(R.id.imagenMain1);

        texto.setScaleX(0f);
        texto.setScaleY(0f);
        texto.setVisibility(View.GONE);

        imagen.setBackgroundResource(R.drawable.animation_lista);
        animationDrawable= (AnimationDrawable) imagen.getBackground();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                texto.setVisibility(View.VISIBLE);
                texto.animate().scaleX(1f).scaleY(1f).setDuration(1000).start();

                texto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //intent
                        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                    }
                });

            }
        },delay);




    }

    //cuando inicia la app
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        animationDrawable.start();//justo cuando cambia, inicia la imagen
    }
}