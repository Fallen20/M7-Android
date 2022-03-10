package com.example.animationscreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    AnimationDrawable animationDrawable=new AnimationDrawable();
    private ImageView imagen;
    private TextView texto;

    public static final int delay=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //v3
        //un bucle porque se llaman igual y son muchos
        //ResourcesCompat.getDrawable(getResources(),getResources().getIdentifier("nombre"+contador,"drawable"))

        texto=findViewById(R.id.textMain3);
        imagen =findViewById(R.id.imagenMain3);

        texto.setScaleX(0f);
        texto.setScaleY(0f);
        texto.setVisibility(View.GONE);

        addFramesLoop();

        imagen.setImageDrawable(animationDrawable);//le damos la animacion a la image
        animationDrawable.start();


        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                texto.setVisibility(View.VISIBLE);
                texto.animate().scaleX(1f).scaleY(1f).setDuration(1000).start();

                texto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //intent
                        Intent intent=new Intent(MainActivity3.this,MainActivity.class);
                        startActivity(intent);
                    }
                });

            }
        },delay);

    }

    private void addFramesLoop() {
        String nombreImagen="spaceship";
        for (int contador=1; contador<=225;contador++){

            animationDrawable.addFrame(ResourcesCompat.getDrawable(
                    getResources(), getResources().getIdentifier(nombreImagen + contador ,
                            "drawable", getPackageName()), null), 20);
            //el 20 es cada cuanto se repite


        }
    }
}