package com.example.edt19;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    private ImageView imagenBG1;//azul
    private ImageView imagenbiciBG;//bici izq
    private LinearLayout linearLayoutBG;//texto del principio

    private ImageView iconoBici;//bici der
    private LinearLayout iconoTexto;//esto ha de dar una vuelta entera
    private RelativeLayout bicisLayout;//bicis de colores


    private ImageView biciAzul;
    private ImageView biciCyan;
    private ImageView biciRoja;
    private ImageView biciNaranja;

    private int movido=0;

    private static ObjectAnimator moverBG;
    private static ObjectAnimator pivotBG;
    private static ObjectAnimator moverTxtBGY;
    private static ObjectAnimator moverTxtBGX;
    private static ObjectAnimator alphaTxtBG;
    private static ObjectAnimator moverBiciIcono;
    private static ObjectAnimator alphaTxtIcono;
    private static ObjectAnimator pivotTxtIcono;
    private static ObjectAnimator moverBicisLinear;
    private static  ObjectAnimator alphaBicisLinear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagenBG1=findViewById(R.id.imagenBG);
        linearLayoutBG=findViewById(R.id.linearBG);
        imagenbiciBG=findViewById(R.id.biciBG);
        iconoBici=findViewById(R.id.iconoBici);
        iconoTexto=findViewById(R.id.linearIcon);
        bicisLayout=findViewById(R.id.layoutBicis);
        biciNaranja =findViewById(R.id.biciNaranja);
        biciCyan =findViewById(R.id.biciCyan);
        biciAzul =findViewById(R.id.biciAzul);
        biciRoja =findViewById(R.id.biciRoja);


        //esto lo hace al iniciar la app, lo hace solo
        moverBG = ObjectAnimator.ofFloat(imagenBG1, "translationY",0f,-2900f);
        moverTxtBGY = ObjectAnimator.ofFloat(linearLayoutBG, "translationY",0f,-900f);
        moverTxtBGX = ObjectAnimator.ofFloat(linearLayoutBG, "translationX",0f,-100f);
        alphaTxtBG= ObjectAnimator.ofFloat(linearLayoutBG, "alpha",1f,0f);
        pivotBG = ObjectAnimator.ofFloat(imagenbiciBG, "translationX",0f, -1000f);

        moverBiciIcono=ObjectAnimator.ofFloat(iconoBici, "translationX", 0f, -680f);
        alphaTxtIcono= ObjectAnimator.ofFloat(iconoTexto, "alpha",0f,1f);
        moverBicisLinear=ObjectAnimator.ofFloat(bicisLayout, "translationY", 0f, -200f);
        alphaBicisLinear= ObjectAnimator.ofFloat(bicisLayout, "alpha",0f,1f);


        pivotTxtIcono= ObjectAnimator.ofFloat(iconoTexto, "rotation",-180f,0f);

        AnimatorSet set=new AnimatorSet();

        moverBG.setStartDelay(500);
        moverTxtBGY.setStartDelay(500);
        moverTxtBGX.setStartDelay(500);
        alphaTxtBG.setStartDelay(500);
        pivotBG.setStartDelay(700);
        moverBiciIcono.setStartDelay(1500);
        alphaTxtIcono.setStartDelay(1500);
        moverBicisLinear.setStartDelay(1500);
        alphaBicisLinear.setStartDelay(1500);
        pivotTxtIcono.setStartDelay(1500);

        moverBG.setDuration(1500);
        pivotBG.setDuration(2000);
        moverTxtBGY.setDuration(1500);
        moverTxtBGX.setDuration(1000);
        alphaTxtBG.setDuration(1500);
        moverBiciIcono.setDuration(800);
        alphaTxtIcono.setDuration(800);
        moverBicisLinear.setDuration(800);
        alphaBicisLinear.setDuration(1000);
        pivotTxtIcono.setDuration(800);

        set.playTogether(moverBG,pivotBG,moverTxtBGY,moverTxtBGX, alphaTxtBG,
                            moverBiciIcono,pivotTxtIcono,alphaTxtIcono,moverBicisLinear,alphaBicisLinear);
        set.start();
//HACE LA TRANSICION BIEN

        //animaciones tras cada click v

        biciCyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                @SuppressLint("ResourceType")
                Animation moverBici= AnimationUtils.loadAnimation(getApplicationContext(),R.animator.spin);
                view.startAnimation(moverBici);

                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent=new Intent(MainActivity.this, SecondActivity.class);

                        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
                            Pair[] pairs=new Pair[2];//num de cosas que movemos
                            pairs[0]=new Pair<View, String>(iconoBici,"biciIconoTrans");
                            pairs[1]=new Pair<View, String>(iconoTexto,"textoIconoTrans");


                            ActivityOptions option=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                            //lo de arriba es necesario para pasar las cosas de arriba a la misma posicion que el otro
                            //o algo asi idk

                            startActivity(intent, option.toBundle());//inicia esto

                        }
                    }
                }, 1000);//poner esto al final es el delay
            }
        });


        biciAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                @SuppressLint("ResourceType")
                Animation moverBici= AnimationUtils.loadAnimation(getApplicationContext(),R.animator.spin);
                view.startAnimation(moverBici);

                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent=new Intent(MainActivity.this, SecondActivity.class);

                        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
                            Pair[] pairs=new Pair[2];//num de cosas que movemos
                            pairs[0]=new Pair<View, String>(iconoBici,"biciIconoTrans");
                            pairs[1]=new Pair<View, String>(iconoTexto,"textoIconoTrans");


                            ActivityOptions option=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                            //lo de arriba es necesario para pasar las cosas de arriba a la misma posicion que el otro
                            //o algo asi idk

                            startActivity(intent, option.toBundle());//inicia esto

                        }
                    }
                }, 1000);//poner esto al final es el delay
            }
        });



        biciRoja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                @SuppressLint("ResourceType")
                Animation moverBici= AnimationUtils.loadAnimation(getApplicationContext(),R.animator.spin);
                view.startAnimation(moverBici);

                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent=new Intent(MainActivity.this, SecondActivity.class);

                        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
                            Pair[] pairs=new Pair[2];//num de cosas que movemos
                            pairs[0]=new Pair<View, String>(iconoBici,"biciIconoTrans");
                            pairs[1]=new Pair<View, String>(iconoTexto,"textoIconoTrans");


                            ActivityOptions option=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                            //lo de arriba es necesario para pasar las cosas de arriba a la misma posicion que el otro
                            //o algo asi idk

                            startActivity(intent, option.toBundle());//inicia esto

                        }
                    }
                }, 1000);//poner esto al final es el delay
            }
        });



        biciNaranja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                @SuppressLint("ResourceType")
                Animation moverBici= AnimationUtils.loadAnimation(getApplicationContext(),R.animator.spin);
                view.startAnimation(moverBici);

                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent=new Intent(MainActivity.this, SecondActivity.class);

                        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
                            Pair[] pairs=new Pair[2];//num de cosas que movemos
                            pairs[0]=new Pair<View, String>(iconoBici,"biciIconoTrans");
                            pairs[1]=new Pair<View, String>(iconoTexto,"textoIconoTrans");


                            ActivityOptions option=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                            //lo de arriba es necesario para pasar las cosas de arriba a la misma posicion que el otro
                            //o algo asi idk

                            startActivity(intent, option.toBundle());//inicia esto

                        }
                    }
                }, 1000);//poner esto al final es el delay
            }
        });



    }


}