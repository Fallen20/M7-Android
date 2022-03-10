package com.example.edt27;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textoImg1_1;
    private TextView textoImg1_2;
    private TextView textoImg1_3;
    private Button botonImg1;
    private ImageView imagen1Top;
    private ImageView imagen1Back;

    private TextView textoImg2_1;
    private TextView textoImg2_2;
    private TextView textoImg2_3;
    private Button botonImg2;
    private ImageView imagen2Top;
    private ImageView imagen2Back;

    private TextView textoImg3_1;
    private TextView textoImg3_2;
    private TextView textoImg3_3;
    private Button botonImg3;
    private ImageView imagen3Top;
    private ImageView imagen3Back;

    private TextView textoImg4_1;
    private TextView textoImg4_2;
    private TextView textoImg4_3;
    private Button botonImg4;
    private ImageView imagen4Top;
    private ImageView imagen4Back;

    private TextView textoImg5_1;
    private TextView textoImg5_2;
    private TextView textoImg5_3;
    private Button botonImg5;
    private ImageView imagen5Top;
    private ImageView imagen5Back;

    private int estadoImg1=0;
    private int estadoImg2=0;
    private int estadoImg3=0;
    private int estadoImg4=0;
    private int estadoImg5=0;

    private ObjectAnimator alphaVisibleTxt1_1;
    private ObjectAnimator alphaVisibleTxt1_2;
    private ObjectAnimator alphaVisibleTxt1_3;
    private ObjectAnimator alphaVisibleBoton1;
    private ObjectAnimator alphaInvisibleImgTop1;
    private ObjectAnimator alphaMedioInvisibleImgBack1;
    private ObjectAnimator rotar1Img1;
    private ObjectAnimator rotar2Img1;

    private ObjectAnimator alphaVisibleTxt2_1;
    private ObjectAnimator alphaVisibleTxt2_2;
    private ObjectAnimator alphaVisibleTxt2_3;
    private ObjectAnimator alphaVisibleBoton2;
    private ObjectAnimator alphaInvisibleImgTop2;
    private ObjectAnimator alphaMedioInvisibleImgBack2;
    private ObjectAnimator rotar1Img2;
    private ObjectAnimator rotar2Img2;

    private ObjectAnimator alphaVisibleTxt3_1;
    private ObjectAnimator alphaVisibleTxt3_2;
    private ObjectAnimator alphaVisibleTxt3_3;
    private ObjectAnimator alphaVisibleBoton3;
    private ObjectAnimator alphaInvisibleImgTop3;
    private ObjectAnimator alphaMedioInvisibleImgBack3;
    private ObjectAnimator rotar1Img3;
    private ObjectAnimator rotar2Img3;

    private ObjectAnimator alphaVisibleTxt4_1;
    private ObjectAnimator alphaVisibleTxt4_2;
    private ObjectAnimator alphaVisibleTxt4_3;
    private ObjectAnimator alphaVisibleBoton4;
    private ObjectAnimator alphaInvisibleImgTop4;
    private ObjectAnimator alphaMedioInvisibleImgBack4;
    private ObjectAnimator rotar1Img4;
    private ObjectAnimator rotar2Img4;


    private ObjectAnimator alphaVisibleTxt5_1;
    private ObjectAnimator alphaVisibleTxt5_2;
    private ObjectAnimator alphaVisibleTxt5_3;
    private ObjectAnimator alphaVisibleBoton5;
    private ObjectAnimator alphaInvisibleImgTop5;
    private ObjectAnimator alphaMedioInvisibleImgBack5;
    private ObjectAnimator rotar1Img5;
    private ObjectAnimator rotar2Img5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoImg1_1= findViewById(R.id.textImage1_1);
        textoImg1_2= findViewById(R.id.textImage1_2);
        textoImg1_3= findViewById(R.id.textImage1_3);
        botonImg1= findViewById(R.id.buttonImg1);
        imagen1Top=findViewById(R.id.image1);
        imagen1Back=findViewById(R.id.image1Back);

        textoImg2_1= findViewById(R.id.textImage2_1);
        textoImg2_2= findViewById(R.id.textImage2_2);
        textoImg2_3= findViewById(R.id.textImage2_3);
        botonImg2= findViewById(R.id.buttonImg2);
        imagen2Top=findViewById(R.id.image2);
        imagen2Back=findViewById(R.id.image2Back);

        textoImg3_1= findViewById(R.id.textImage3_1);
        textoImg3_2= findViewById(R.id.textImage3_2);
        textoImg3_3= findViewById(R.id.textImage3_3);
        botonImg3= findViewById(R.id.buttonImg3);
        imagen3Top=findViewById(R.id.image3);
        imagen3Back=findViewById(R.id.image3Back);

        textoImg4_1= findViewById(R.id.textImage4_1);
        textoImg4_2= findViewById(R.id.textImage4_2);
        textoImg4_3= findViewById(R.id.textImage4_3);
        botonImg4= findViewById(R.id.buttonImg4);
        imagen4Top=findViewById(R.id.image4);
        imagen4Back=findViewById(R.id.blancoImg4);

        textoImg5_1= findViewById(R.id.textImage5_1);
        textoImg5_2= findViewById(R.id.textImage5_2);
        textoImg5_3= findViewById(R.id.textImage5_3);
        botonImg5= findViewById(R.id.buttonImg5);
        imagen5Top=findViewById(R.id.image5);
        imagen5Back=findViewById(R.id.image5Back);



        botonImg1.setClickable(false);
        botonImg2.setClickable(false);
        botonImg3.setClickable(false);
        botonImg4.setClickable(false);
        botonImg5.setClickable(false);



        imagen1Top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(estadoImg1==0){

                    alphaMedioInvisibleImgBack1 =ObjectAnimator.ofFloat(imagen1Back, "alpha",0f,.5f);//de invisible a poca opacidad
                    rotar2Img1 =ObjectAnimator.ofFloat(imagen1Back, "rotationY",0f,180f);//gira

                    alphaInvisibleImgTop1 =ObjectAnimator.ofFloat(v, "alpha",1f,0f);//de visible a invisible
                    rotar1Img1 =ObjectAnimator.ofFloat(v, "rotationY",0f,180f);//gira

                    //textos
                    alphaVisibleTxt1_1 =ObjectAnimator.ofFloat(textoImg1_1, "alpha",0f,1f);
                    alphaVisibleTxt1_2 =ObjectAnimator.ofFloat(textoImg1_2, "alpha",0f,1f);
                    alphaVisibleTxt1_3 =ObjectAnimator.ofFloat(textoImg1_3, "alpha",0f,1f);

                    //boton
                    alphaVisibleBoton1 =ObjectAnimator.ofFloat(botonImg1, "alpha",0f,1f);

                    alphaMedioInvisibleImgBack1.setStartDelay(500);
                    alphaInvisibleImgTop1.setStartDelay(500);
                    alphaVisibleTxt1_1.setStartDelay(500);
                    alphaVisibleTxt1_2.setStartDelay(500);
                    alphaVisibleTxt1_3.setStartDelay(500);

                    alphaVisibleBoton1.setStartDelay(500);

                    alphaMedioInvisibleImgBack1.setDuration(0);
                    alphaInvisibleImgTop1.setDuration(0);
                    rotar1Img1.setDuration(1000);
                    rotar2Img1.setDuration(1000);

                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img1, alphaInvisibleImgTop1, alphaMedioInvisibleImgBack1, rotar2Img1, alphaVisibleTxt1_1, alphaVisibleTxt1_2, alphaVisibleTxt1_3, alphaVisibleBoton1);
                    set.start();
                    botonImg1.setClickable(true);
                    estadoImg1=1;
                }
                else{
                    alphaMedioInvisibleImgBack1 =ObjectAnimator.ofFloat(imagen1Back, "alpha",.5f,0f);//de invisible a poca opacidad
                    rotar2Img1 =ObjectAnimator.ofFloat(imagen1Back, "rotationY",180f,0f);

                    alphaInvisibleImgTop1 =ObjectAnimator.ofFloat(v, "alpha",0f,1f);//de invisible a poca opacidad
                    rotar1Img1 =ObjectAnimator.ofFloat(v, "rotationY",180f,0f);

                    alphaVisibleTxt1_1 =ObjectAnimator.ofFloat(textoImg1_1, "alpha",1f,0f);
                    alphaVisibleTxt1_2 =ObjectAnimator.ofFloat(textoImg1_2, "alpha",1f,0f);
                    alphaVisibleTxt1_3 =ObjectAnimator.ofFloat(textoImg1_3, "alpha",1f,0f);

                    alphaVisibleBoton1 =ObjectAnimator.ofFloat(botonImg1, "alpha",1f,0f);

                    alphaMedioInvisibleImgBack1.setStartDelay(500);
                    alphaInvisibleImgTop1.setStartDelay(500);
                    alphaVisibleTxt1_1.setStartDelay(200);
                    alphaVisibleTxt1_2.setStartDelay(200);
                    alphaVisibleTxt1_3.setStartDelay(200);

                    alphaVisibleBoton1.setStartDelay(200);

                    alphaMedioInvisibleImgBack1.setDuration(0);
                    alphaInvisibleImgTop1.setDuration(0);
                    rotar1Img1.setDuration(1000);
                    rotar2Img1.setDuration(1000);

                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img1, alphaInvisibleImgTop1, alphaMedioInvisibleImgBack1, rotar2Img1, alphaVisibleTxt1_1, alphaVisibleTxt1_2, alphaVisibleTxt1_3, alphaVisibleBoton1);
                    set.start();
                    botonImg1.setClickable(false);
                    estadoImg1=0;
                }
            }
        });

        imagen2Top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(estadoImg2==0){

                    alphaMedioInvisibleImgBack2 =ObjectAnimator.ofFloat(imagen2Back, "alpha",0f,.5f);//de invisible a poca opacidad
                    rotar2Img2 =ObjectAnimator.ofFloat(imagen2Back, "rotationY",0f,180f);//gira

                    alphaInvisibleImgTop2 =ObjectAnimator.ofFloat(v, "alpha",1f,0f);//de visible a invisible
                    rotar1Img2 =ObjectAnimator.ofFloat(v, "rotationY",0f,180f);//gira

                    //textos
                    alphaVisibleTxt2_1 =ObjectAnimator.ofFloat(textoImg2_1, "alpha",0f,1f);
                    alphaVisibleTxt2_2 =ObjectAnimator.ofFloat(textoImg2_2, "alpha",0f,1f);
                    alphaVisibleTxt2_3 =ObjectAnimator.ofFloat(textoImg2_3, "alpha",0f,1f);

                    //boton
                    alphaVisibleBoton2 =ObjectAnimator.ofFloat(botonImg2, "alpha",0f,1f);

                    alphaMedioInvisibleImgBack2.setStartDelay(500);
                    alphaInvisibleImgTop2.setStartDelay(500);
                    alphaVisibleTxt2_1.setStartDelay(500);
                    alphaVisibleTxt2_2.setStartDelay(500);
                    alphaVisibleTxt2_3.setStartDelay(500);

                    alphaVisibleBoton2.setStartDelay(500);

                    alphaMedioInvisibleImgBack2.setDuration(0);
                    alphaInvisibleImgTop2.setDuration(0);
                    rotar1Img2.setDuration(1000);
                    rotar2Img2.setDuration(1000);

                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img2, alphaInvisibleImgTop2, alphaMedioInvisibleImgBack2, rotar2Img2, alphaVisibleTxt2_1, alphaVisibleTxt2_2, alphaVisibleTxt2_3, alphaVisibleBoton2);
                    set.start();
                    botonImg2.setClickable(true);
                    estadoImg2=1;
                }
                else{
                    alphaMedioInvisibleImgBack2 =ObjectAnimator.ofFloat(imagen2Back, "alpha",.5f,0f);//de invisible a poca opacidad
                    rotar2Img2 =ObjectAnimator.ofFloat(imagen2Back, "rotationY",180f,0f);

                    alphaInvisibleImgTop2 =ObjectAnimator.ofFloat(v, "alpha",0f,1f);//de invisible a poca opacidad
                    rotar1Img2 =ObjectAnimator.ofFloat(v, "rotationY",180f,0f);

                    alphaVisibleTxt2_1 =ObjectAnimator.ofFloat(textoImg2_1, "alpha",1f,0f);
                    alphaVisibleTxt2_2 =ObjectAnimator.ofFloat(textoImg2_2, "alpha",1f,0f);
                    alphaVisibleTxt2_3 =ObjectAnimator.ofFloat(textoImg2_3, "alpha",1f,0f);

                    alphaVisibleBoton2 =ObjectAnimator.ofFloat(botonImg2, "alpha",1f,0f);

                    alphaMedioInvisibleImgBack2.setStartDelay(500);
                    alphaInvisibleImgTop2.setStartDelay(500);
                    alphaVisibleTxt2_1.setStartDelay(200);
                    alphaVisibleTxt2_2.setStartDelay(200);
                    alphaVisibleTxt2_3.setStartDelay(200);

                    alphaVisibleBoton2.setStartDelay(200);

                    alphaMedioInvisibleImgBack2.setDuration(0);
                    alphaInvisibleImgTop2.setDuration(0);
                    rotar1Img2.setDuration(1000);
                    rotar2Img2.setDuration(1000);

                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img2, alphaInvisibleImgTop2, alphaMedioInvisibleImgBack2, rotar2Img2, alphaVisibleTxt2_1, alphaVisibleTxt2_2, alphaVisibleTxt2_3, alphaVisibleBoton2);
                    set.start();
                    botonImg2.setClickable(false);
                    estadoImg2=0;
                }
            }
        });

        imagen3Top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(estadoImg3==0){

                    alphaMedioInvisibleImgBack3 =ObjectAnimator.ofFloat(imagen3Back, "alpha",0f,.5f);//de invisible a poca opacidad
                    rotar2Img3 =ObjectAnimator.ofFloat(imagen3Back, "rotationY",0f,180f);//gira

                    alphaInvisibleImgTop3 =ObjectAnimator.ofFloat(v, "alpha",1f,0f);//de visible a invisible
                    rotar1Img3 =ObjectAnimator.ofFloat(v, "rotationY",0f,180f);//gira

                    //textos
                    alphaVisibleTxt3_1 =ObjectAnimator.ofFloat(textoImg3_1, "alpha",0f,1f);
                    alphaVisibleTxt3_2 =ObjectAnimator.ofFloat(textoImg3_2, "alpha",0f,1f);
                    alphaVisibleTxt3_3 =ObjectAnimator.ofFloat(textoImg3_3, "alpha",0f,1f);

                    //boton
                    alphaVisibleBoton3 =ObjectAnimator.ofFloat(botonImg3, "alpha",0f,1f);

                    alphaMedioInvisibleImgBack3.setStartDelay(500);
                    alphaInvisibleImgTop3.setStartDelay(500);
                    alphaVisibleTxt3_1.setStartDelay(500);
                    alphaVisibleTxt3_2.setStartDelay(500);
                    alphaVisibleTxt3_3.setStartDelay(500);

                    alphaVisibleBoton3.setStartDelay(500);

                    alphaMedioInvisibleImgBack3.setDuration(0);
                    alphaInvisibleImgTop3.setDuration(0);
                    rotar1Img3.setDuration(1000);
                    rotar2Img3.setDuration(1000);

                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img3, alphaInvisibleImgTop3, alphaMedioInvisibleImgBack3, rotar2Img3, alphaVisibleTxt3_1, alphaVisibleTxt3_2, alphaVisibleTxt3_3, alphaVisibleBoton3);
                    set.start();
                    botonImg3.setClickable(true);
                    estadoImg3=1;
                }
                else{
                    alphaMedioInvisibleImgBack3 =ObjectAnimator.ofFloat(imagen3Back, "alpha",.5f,0f);//de invisible a poca opacidad
                    rotar2Img3 =ObjectAnimator.ofFloat(imagen3Back, "rotationY",180f,0f);

                    alphaInvisibleImgTop3 =ObjectAnimator.ofFloat(v, "alpha",0f,1f);//de invisible a poca opacidad
                    rotar1Img3 =ObjectAnimator.ofFloat(v, "rotationY",180f,0f);

                    alphaVisibleTxt3_1 =ObjectAnimator.ofFloat(textoImg3_1, "alpha",1f,0f);
                    alphaVisibleTxt3_2 =ObjectAnimator.ofFloat(textoImg3_2, "alpha",1f,0f);
                    alphaVisibleTxt3_3 =ObjectAnimator.ofFloat(textoImg3_3, "alpha",1f,0f);

                    alphaVisibleBoton3 =ObjectAnimator.ofFloat(botonImg3, "alpha",1f,0f);

                    alphaMedioInvisibleImgBack3.setStartDelay(500);
                    alphaInvisibleImgTop3.setStartDelay(500);
                    alphaVisibleTxt3_1.setStartDelay(200);
                    alphaVisibleTxt3_2.setStartDelay(200);
                    alphaVisibleTxt3_3.setStartDelay(200);

                    alphaVisibleBoton3.setStartDelay(200);

                    alphaMedioInvisibleImgBack3.setDuration(0);
                    alphaInvisibleImgTop3.setDuration(0);
                    rotar1Img3.setDuration(1000);
                    rotar2Img3.setDuration(1000);

                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img3, alphaInvisibleImgTop3, alphaMedioInvisibleImgBack3, rotar2Img3, alphaVisibleTxt3_1, alphaVisibleTxt3_2, alphaVisibleTxt3_3, alphaVisibleBoton3);
                    set.start();
                    botonImg3.setClickable(false);
                    estadoImg3=0;
                }
            }
        });

        imagen4Top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(estadoImg4==0){

                    alphaMedioInvisibleImgBack4 =ObjectAnimator.ofFloat(imagen4Back, "alpha",0f,.5f);//de invisible a poca opacidad
                    rotar2Img4 =ObjectAnimator.ofFloat(imagen4Back, "rotationY",0f,180f);//gira

                    alphaInvisibleImgTop4 =ObjectAnimator.ofFloat(v, "alpha",1f,0f);//de visible a invisible
                    rotar1Img4 =ObjectAnimator.ofFloat(v, "rotationY",0f,180f);//gira

                    //textos
                    alphaVisibleTxt4_1 =ObjectAnimator.ofFloat(textoImg4_1, "alpha",0f,1f);
                    alphaVisibleTxt4_2 =ObjectAnimator.ofFloat(textoImg4_2, "alpha",0f,1f);
                    alphaVisibleTxt4_3 =ObjectAnimator.ofFloat(textoImg4_3, "alpha",0f,1f);

                    //boton
                    alphaVisibleBoton4 =ObjectAnimator.ofFloat(botonImg4, "alpha",0f,1f);

                    alphaMedioInvisibleImgBack4.setStartDelay(500);
                    alphaInvisibleImgTop4.setStartDelay(500);
                    alphaVisibleTxt4_1.setStartDelay(500);
                    alphaVisibleTxt4_2.setStartDelay(500);
                    alphaVisibleTxt4_3.setStartDelay(500);

                    alphaVisibleBoton4.setStartDelay(500);

                    alphaMedioInvisibleImgBack4.setDuration(0);
                    alphaInvisibleImgTop4.setDuration(0);
                    rotar1Img4.setDuration(1000);
                    rotar2Img4.setDuration(1000);

                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img4, alphaInvisibleImgTop4, alphaMedioInvisibleImgBack4, rotar2Img4, alphaVisibleTxt4_1, alphaVisibleTxt4_2, alphaVisibleTxt4_3, alphaVisibleBoton4);
                    set.start();
                    botonImg4.setClickable(true);
                    estadoImg4=1;
                }
                else{
                    alphaMedioInvisibleImgBack4 =ObjectAnimator.ofFloat(imagen4Back, "alpha",.5f,0f);//de invisible a poca opacidad
                    rotar2Img4 =ObjectAnimator.ofFloat(imagen4Back, "rotationY",180f,0f);

                    alphaInvisibleImgTop4 =ObjectAnimator.ofFloat(v, "alpha",0f,1f);//de invisible a poca opacidad
                    rotar1Img4 =ObjectAnimator.ofFloat(v, "rotationY",180f,0f);

                    alphaVisibleTxt4_1 =ObjectAnimator.ofFloat(textoImg4_1, "alpha",1f,0f);
                    alphaVisibleTxt4_2 =ObjectAnimator.ofFloat(textoImg4_2, "alpha",1f,0f);
                    alphaVisibleTxt4_3 =ObjectAnimator.ofFloat(textoImg4_3, "alpha",1f,0f);

                    alphaVisibleBoton4 =ObjectAnimator.ofFloat(botonImg4, "alpha",1f,0f);

                    alphaMedioInvisibleImgBack4.setStartDelay(500);
                    alphaInvisibleImgTop4.setStartDelay(500);
                    alphaVisibleTxt4_1.setStartDelay(200);
                    alphaVisibleTxt4_2.setStartDelay(200);
                    alphaVisibleTxt4_3.setStartDelay(200);

                    alphaVisibleBoton4.setStartDelay(200);

                    alphaMedioInvisibleImgBack4.setDuration(0);
                    alphaInvisibleImgTop4.setDuration(0);
                    rotar1Img4.setDuration(1000);
                    rotar2Img4.setDuration(1000);

                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img4, alphaInvisibleImgTop4, alphaMedioInvisibleImgBack4, rotar2Img4, alphaVisibleTxt4_1, alphaVisibleTxt4_2, alphaVisibleTxt4_3, alphaVisibleBoton4);
                    set.start();
                    botonImg4.setClickable(false);
                    estadoImg4=0;
                }
            }
        });


        imagen5Top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(estadoImg5==0){

                    alphaMedioInvisibleImgBack5 =ObjectAnimator.ofFloat(imagen5Back, "alpha",0f,.5f);//de invisible a poca opacidad
                    rotar2Img5 =ObjectAnimator.ofFloat(imagen5Back, "rotationY",0f,180f);//gira

                    alphaInvisibleImgTop5 =ObjectAnimator.ofFloat(v, "alpha",1f,0f);//de visible a invisible
                    rotar1Img5 =ObjectAnimator.ofFloat(v, "rotationY",0f,180f);//gira

                    //textos
                    alphaVisibleTxt5_1 =ObjectAnimator.ofFloat(textoImg5_1, "alpha",0f,1f);
                    alphaVisibleTxt5_2 =ObjectAnimator.ofFloat(textoImg5_2, "alpha",0f,1f);
                    alphaVisibleTxt5_3 =ObjectAnimator.ofFloat(textoImg5_3, "alpha",0f,1f);

                    //boton
                    alphaVisibleBoton5 =ObjectAnimator.ofFloat(botonImg5, "alpha",0f,1f);

                    alphaMedioInvisibleImgBack5.setStartDelay(500);
                    alphaInvisibleImgTop5.setStartDelay(500);
                    alphaVisibleTxt5_1.setStartDelay(500);
                    alphaVisibleTxt5_2.setStartDelay(500);
                    alphaVisibleTxt5_3.setStartDelay(500);

                    alphaVisibleBoton5.setStartDelay(500);

                    alphaMedioInvisibleImgBack5.setDuration(0);
                    alphaInvisibleImgTop5.setDuration(0);
                    rotar1Img5.setDuration(1000);
                    rotar2Img5.setDuration(1000);

                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img5, alphaInvisibleImgTop5,alphaMedioInvisibleImgBack5, rotar2Img5, alphaVisibleTxt5_1, alphaVisibleTxt5_2, alphaVisibleTxt5_3, alphaVisibleBoton5);
                    set.start();
                    botonImg5.setClickable(true);
                    estadoImg5=1;
                }
                else{
                    alphaMedioInvisibleImgBack5 =ObjectAnimator.ofFloat(imagen5Back, "alpha",.5f,0f);//de invisible a poca opacidad
                    rotar2Img5 =ObjectAnimator.ofFloat(imagen5Back, "rotationY",180f,0f);

                    alphaInvisibleImgTop5 =ObjectAnimator.ofFloat(v, "alpha",0f,1f);//de invisible a poca opacidad
                    rotar1Img5 =ObjectAnimator.ofFloat(v, "rotationY",180f,0f);

                    alphaVisibleTxt5_1 =ObjectAnimator.ofFloat(textoImg5_1, "alpha",1f,0f);
                    alphaVisibleTxt5_2 =ObjectAnimator.ofFloat(textoImg5_2, "alpha",1f,0f);
                    alphaVisibleTxt5_3 =ObjectAnimator.ofFloat(textoImg5_3, "alpha",1f,0f);

                    alphaVisibleBoton5 =ObjectAnimator.ofFloat(botonImg5, "alpha",1f,0f);

                    alphaMedioInvisibleImgBack5.setStartDelay(500);
                    alphaInvisibleImgTop5.setStartDelay(500);
                    alphaVisibleTxt5_1.setStartDelay(200);
                    alphaVisibleTxt5_2.setStartDelay(200);
                    alphaVisibleTxt5_3.setStartDelay(200);

                    alphaVisibleBoton5.setStartDelay(200);

                    alphaMedioInvisibleImgBack5.setDuration(0);
                    alphaInvisibleImgTop5.setDuration(0);
                    rotar1Img5.setDuration(1000);
                    rotar2Img5.setDuration(1000);

                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img5, alphaInvisibleImgTop5, alphaMedioInvisibleImgBack5, rotar2Img5, alphaVisibleTxt5_1, alphaVisibleTxt5_2, alphaVisibleTxt5_3, alphaVisibleBoton5);
                    set.start();
                    botonImg5.setClickable(false);
                    estadoImg5=0;
                }
            }
        });

    }
    public void intentClick(View view) {
        Intent intent = new Intent(MainActivity.this, ReservarActivity.class);
        if(botonImg1.isClickable() || botonImg2.isClickable() || botonImg3.isClickable() || botonImg4.isClickable() || botonImg5.isClickable()){
            startActivity(intent);
        }

    }
}