package com.example.edt27;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button botonImg1;
    private ImageView imagen1Top;
    private ImageView imagen1Back;
    private LinearLayout rotar1Linear;

    private Button botonImg2;
    private ImageView imagen2Top;
    private ImageView imagen2Back;
    private LinearLayout rotar2Linear;


    private Button botonImg3;
    private ImageView imagen3Top;
    private ImageView imagen3Back;
    private LinearLayout rotar3Linear;


    private Button botonImg4;
    private ImageView imagen4Top;
    private ImageView imagen4Back;
    private LinearLayout rotar4Linear;


    private Button botonImg5;
    private ImageView imagen5Top;
    private ImageView imagen5Back;
    private LinearLayout rotar5Linear;



    //ESTADOS
    private int estadoImg1=0;
    private int estadoImg2=0;
    private int estadoImg3=0;
    private int estadoImg4=0;
    private int estadoImg5=0;

    //ANIMATION
    private ObjectAnimator alphaInvisibleImgTop1;
    private ObjectAnimator alphaMedioInvisibleImgBack1;
    private ObjectAnimator rotar1Img1;
    private ObjectAnimator rotar2Img1;
    private ObjectAnimator rotarLinear1;
    private ObjectAnimator alphaLinear1;


    private ObjectAnimator alphaInvisibleImgTop2;
    private ObjectAnimator alphaMedioInvisibleImgBack2;
    private ObjectAnimator rotar1Img2;
    private ObjectAnimator rotar2Img2;
    private ObjectAnimator rotarLinear2;
    private ObjectAnimator alphaLinear2;


    private ObjectAnimator alphaInvisibleImgTop3;
    private ObjectAnimator alphaMedioInvisibleImgBack3;
    private ObjectAnimator rotar1Img3;
    private ObjectAnimator rotar2Img3;
    private ObjectAnimator rotarLinear3;
    private ObjectAnimator alphaLinear3;


    private ObjectAnimator alphaInvisibleImgTop4;
    private ObjectAnimator alphaMedioInvisibleImgBack4;
    private ObjectAnimator rotar1Img4;
    private ObjectAnimator rotar2Img4;
    private ObjectAnimator rotarLinear4;
    private ObjectAnimator alphaLinear4;


    private ObjectAnimator alphaInvisibleImgTop5;
    private ObjectAnimator alphaMedioInvisibleImgBack5;
    private ObjectAnimator rotar1Img5;
    private ObjectAnimator rotar2Img5;
    private ObjectAnimator rotarLinear5;
    private ObjectAnimator alphaLinear5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botonImg1= findViewById(R.id.buttonImg1);
        imagen1Top=findViewById(R.id.image1);
        imagen1Back=findViewById(R.id.image1Back);
        rotar1Linear =findViewById(R.id.linear1Vertical);

        botonImg2= findViewById(R.id.buttonImg2);
        imagen2Top=findViewById(R.id.image2);
        imagen2Back=findViewById(R.id.image2Back);
        rotar2Linear =findViewById(R.id.linear2Vertical);

        botonImg3= findViewById(R.id.buttonImg3);
        imagen3Top=findViewById(R.id.image3);
        imagen3Back=findViewById(R.id.image3Back);
        rotar3Linear =findViewById(R.id.linear3Vertical);

        botonImg4= findViewById(R.id.buttonImg4);
        imagen4Top=findViewById(R.id.image4);
        imagen4Back=findViewById(R.id.image4Back);
        rotar4Linear =findViewById(R.id.linear4Vertical);

        botonImg5= findViewById(R.id.buttonImg5);
        imagen5Top=findViewById(R.id.image5);
        imagen5Back=findViewById(R.id.image5Back);
        rotar5Linear =findViewById(R.id.linear5Vertical);

        botonImg1.setClickable(false);
        botonImg2.setClickable(false);
        botonImg3.setClickable(false);
        botonImg4.setClickable(false);
        botonImg5.setClickable(false);



        imagen1Top.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ObjectAnimatorBinding")
            @Override
            public void onClick(View v) {

                if(estadoImg1==0){

                    alphaInvisibleImgTop1 =ObjectAnimator.ofFloat(v, "alpha",1f,0f);//de visible a invisible
                    rotar1Img1 =ObjectAnimator.ofFloat(v, "rotationY",0f,180f);//gira


                    alphaMedioInvisibleImgBack1 =ObjectAnimator.ofFloat(imagen1Back, "alpha",0f,.5f);//de invisible a poca opacidad
                    rotar2Img1 =ObjectAnimator.ofFloat(imagen1Back, "rotationY",0f,180f);//gira


                    //textos
                    alphaLinear1 =ObjectAnimator.ofFloat(rotar1Linear, "alpha",0f,1f);
                    rotarLinear1 =ObjectAnimator.ofFloat(rotar1Linear, "rotationY",-180f,-0f);//gira
                    alphaLinear1.setStartDelay(130);
                    rotarLinear1.setDuration(1000);
                    alphaLinear1.setDuration(1000);

                    alphaMedioInvisibleImgBack1.setStartDelay(500);
                    alphaInvisibleImgTop1.setStartDelay(500);


                    alphaMedioInvisibleImgBack1.setDuration(0);
                    alphaInvisibleImgTop1.setDuration(0);
                    rotar1Img1.setDuration(1000);
                    rotar2Img1.setDuration(1000);

                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img1, alphaInvisibleImgTop1, alphaLinear1,rotarLinear1, alphaMedioInvisibleImgBack1, rotar2Img1);
                    set.start();
                    botonImg1.setClickable(true);

                    botonImg1.setActivated(true);
                    estadoImg1=1;
                }
                else{
                    alphaMedioInvisibleImgBack1 =ObjectAnimator.ofFloat(imagen1Back, "alpha",.5f,0f);//de invisible a poca opacidad
                    rotar2Img1 =ObjectAnimator.ofFloat(imagen1Back, "rotationY",180f,0f);

                    alphaInvisibleImgTop1 =ObjectAnimator.ofFloat(v, "alpha",0f,1f);//de invisible a poca opacidad
                    rotar1Img1 =ObjectAnimator.ofFloat(v, "rotationY",180f,0f);

                    alphaLinear1 =ObjectAnimator.ofFloat(rotar1Linear, "alpha",1f,0f);//texto alpha
                    rotarLinear1 =ObjectAnimator.ofFloat(rotar1Linear, "rotationY",-0f,-180f);//gira

                    rotarLinear1.setDuration(1000);
                    alphaLinear1.setDuration(800);

                    alphaMedioInvisibleImgBack1.setStartDelay(500);
                    alphaInvisibleImgTop1.setStartDelay(500);



                    alphaMedioInvisibleImgBack1.setDuration(0);
                    alphaInvisibleImgTop1.setDuration(0);
                    rotar1Img1.setDuration(1000);
                    rotar2Img1.setDuration(1000);

                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img1, alphaInvisibleImgTop1, alphaLinear1,rotarLinear1, alphaMedioInvisibleImgBack1, rotar2Img1);
                    set.start();
                    botonImg1.setClickable(false);
                    botonImg1.setActivated(false);
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
                    alphaLinear2 =ObjectAnimator.ofFloat(rotar2Linear, "alpha",0f,1f);
                    rotarLinear2 =ObjectAnimator.ofFloat(rotar2Linear, "rotationY",-180f,-0f);//gira
                    rotarLinear2.setDuration(1000);
                    alphaLinear2.setDuration(1000);

                    alphaMedioInvisibleImgBack2.setStartDelay(500);
                    alphaInvisibleImgTop2.setStartDelay(500);


                    alphaMedioInvisibleImgBack2.setDuration(0);
                    alphaInvisibleImgTop2.setDuration(0);
                    rotar1Img2.setDuration(1000);
                    rotar2Img2.setDuration(1000);


                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img2, alphaInvisibleImgTop2, alphaLinear2, rotarLinear2,alphaMedioInvisibleImgBack2, rotar2Img2);
                    set.start();
                    botonImg2.setClickable(true);
                    estadoImg2=1;
                }
                else{
                    alphaMedioInvisibleImgBack2 =ObjectAnimator.ofFloat(imagen2Back, "alpha",.5f,0f);//de invisible a poca opacidad
                    rotar2Img2 =ObjectAnimator.ofFloat(imagen2Back, "rotationY",180f,0f);

                    alphaInvisibleImgTop2 =ObjectAnimator.ofFloat(v, "alpha",0f,1f);//de invisible a poca opacidad
                    rotar1Img2 =ObjectAnimator.ofFloat(v, "rotationY",180f,0f);

                    alphaLinear2 =ObjectAnimator.ofFloat(rotar2Linear, "alpha",1f,0f);
                    rotarLinear2 =ObjectAnimator.ofFloat(rotar2Linear, "rotationY",-0f,-180f);//gira
                    rotarLinear2.setDuration(1000);
                    alphaLinear2.setDuration(1000);

                    alphaMedioInvisibleImgBack2.setStartDelay(500);
                    alphaInvisibleImgTop2.setStartDelay(500);


                    alphaMedioInvisibleImgBack2.setDuration(0);
                    alphaInvisibleImgTop2.setDuration(0);
                    rotar1Img2.setDuration(1000);
                    rotar2Img2.setDuration(1000);
                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img2, alphaInvisibleImgTop2, alphaLinear2, rotarLinear2,alphaMedioInvisibleImgBack2, rotar2Img2);
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
                    alphaLinear3 =ObjectAnimator.ofFloat(rotar3Linear, "alpha",0f,1f);
                    rotarLinear3 =ObjectAnimator.ofFloat(rotar3Linear, "rotationY",-180f,-0f);//gira
                    rotarLinear3.setDuration(1000);
                    alphaLinear3.setDuration(1000);

                    alphaMedioInvisibleImgBack3.setStartDelay(500);
                    alphaInvisibleImgTop3.setStartDelay(500);


                    alphaMedioInvisibleImgBack3.setDuration(0);
                    alphaInvisibleImgTop3.setDuration(0);
                    rotar1Img3.setDuration(1000);
                    rotar2Img3.setDuration(1000);


                    AnimatorSet set=new AnimatorSet();
                    botonImg3.setClickable(true);
                    set.playTogether(rotar1Img3, alphaInvisibleImgTop3, alphaLinear3, rotarLinear3,alphaMedioInvisibleImgBack3, rotar2Img3);
                    set.start();

                    estadoImg3=1;
                }
                else{
                    alphaMedioInvisibleImgBack3 =ObjectAnimator.ofFloat(imagen3Back, "alpha",.5f,0f);//de invisible a poca opacidad
                    rotar2Img3 =ObjectAnimator.ofFloat(imagen3Back, "rotationY",180f,0f);

                    alphaInvisibleImgTop3 =ObjectAnimator.ofFloat(v, "alpha",0f,1f);//de invisible a poca opacidad
                    rotar1Img3 =ObjectAnimator.ofFloat(v, "rotationY",180f,0f);

                    //textos
                    alphaLinear3 =ObjectAnimator.ofFloat(rotar3Linear, "alpha",1f,0f);
                    rotarLinear3 =ObjectAnimator.ofFloat(rotar3Linear, "rotationY",-0f,-180f);//gira
                    rotarLinear3.setDuration(1000);
                    alphaLinear3.setDuration(1000);

                    alphaMedioInvisibleImgBack3.setStartDelay(500);
                    alphaInvisibleImgTop3.setStartDelay(500);


                    alphaMedioInvisibleImgBack3.setDuration(0);
                    alphaInvisibleImgTop3.setDuration(0);
                    rotar1Img3.setDuration(1000);
                    rotar2Img3.setDuration(1000);


                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img3, alphaInvisibleImgTop3, alphaLinear3, rotarLinear3,alphaMedioInvisibleImgBack3, rotar2Img3);
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
                    alphaLinear4 =ObjectAnimator.ofFloat(rotar4Linear, "alpha",0f,1f);
                    rotarLinear4 =ObjectAnimator.ofFloat(rotar4Linear, "rotationY",-180f,-0f);//gira
                    rotarLinear4.setDuration(1000);
                    alphaLinear4.setDuration(1000);

                    alphaMedioInvisibleImgBack4.setStartDelay(500);
                    alphaInvisibleImgTop4.setStartDelay(500);

                    alphaMedioInvisibleImgBack4.setDuration(0);
                    alphaInvisibleImgTop4.setDuration(0);
                    rotar1Img4.setDuration(1000);
                    rotar2Img4.setDuration(1000);


                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img4, alphaInvisibleImgTop4,alphaLinear4, rotarLinear4, alphaMedioInvisibleImgBack4, rotar2Img4);
                    set.start();
                    botonImg4.setClickable(true);
                    estadoImg4=1;
                }
                else{
                    alphaMedioInvisibleImgBack4 =ObjectAnimator.ofFloat(imagen4Back, "alpha",.5f,0f);//de invisible a poca opacidad
                    rotar2Img4 =ObjectAnimator.ofFloat(imagen4Back, "rotationY",180f,0f);

                    alphaInvisibleImgTop4 =ObjectAnimator.ofFloat(v, "alpha",0f,1f);//de invisible a poca opacidad
                    rotar1Img4 =ObjectAnimator.ofFloat(v, "rotationY",180f,0f);

                    //textos
                    alphaLinear4 =ObjectAnimator.ofFloat(rotar4Linear, "alpha",1f,0f);
                    rotarLinear4 =ObjectAnimator.ofFloat(rotar4Linear, "rotationY",-0f,-180f);//gira
                    rotarLinear4.setDuration(1000);
                    alphaLinear4.setDuration(1000);

                    alphaMedioInvisibleImgBack4.setStartDelay(500);
                    alphaInvisibleImgTop4.setStartDelay(500);


                    alphaMedioInvisibleImgBack4.setDuration(0);
                    alphaInvisibleImgTop4.setDuration(0);
                    rotar1Img4.setDuration(1000);
                    rotar2Img4.setDuration(1000);

                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img4, alphaInvisibleImgTop4,alphaLinear4, rotarLinear4, alphaMedioInvisibleImgBack4, rotar2Img4);
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
                    alphaLinear5 =ObjectAnimator.ofFloat(rotar5Linear, "alpha",0f,1f);
                    rotarLinear5 =ObjectAnimator.ofFloat(rotar5Linear, "rotationY",-180f,-0f);//gira
                    rotarLinear5.setDuration(1000);
                    alphaLinear5.setDuration(1000);

                    alphaMedioInvisibleImgBack5.setStartDelay(500);
                    alphaInvisibleImgTop5.setStartDelay(500);

                    alphaMedioInvisibleImgBack5.setDuration(0);
                    alphaInvisibleImgTop5.setDuration(0);
                    rotar1Img5.setDuration(1000);
                    rotar2Img5.setDuration(1000);

                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img5, alphaInvisibleImgTop5,alphaLinear5, rotarLinear5,alphaMedioInvisibleImgBack5, rotar2Img5);
                    set.start();
                    botonImg5.setClickable(true);
                    estadoImg5=1;
                }
                else{
                    alphaMedioInvisibleImgBack5 =ObjectAnimator.ofFloat(imagen5Back, "alpha",.5f,0f);//de invisible a poca opacidad
                    rotar2Img5 =ObjectAnimator.ofFloat(imagen5Back, "rotationY",180f,0f);

                    alphaInvisibleImgTop5 =ObjectAnimator.ofFloat(v, "alpha",0f,1f);//de invisible a poca opacidad
                    rotar1Img5 =ObjectAnimator.ofFloat(v, "rotationY",180f,0f);

                    //textos
                    alphaLinear5 =ObjectAnimator.ofFloat(rotar5Linear, "alpha",1f,0f);
                    rotarLinear5 =ObjectAnimator.ofFloat(rotar5Linear, "rotationY",-0f,-180f);//gira
                    rotarLinear5.setDuration(1000);
                    alphaLinear5.setDuration(1000);

                    alphaMedioInvisibleImgBack5.setStartDelay(500);
                    alphaInvisibleImgTop5.setStartDelay(500);

                    alphaMedioInvisibleImgBack5.setDuration(0);
                    alphaInvisibleImgTop5.setDuration(0);
                    rotar1Img5.setDuration(1000);
                    rotar2Img5.setDuration(1000);

                    AnimatorSet set=new AnimatorSet();
                    set.playTogether(rotar1Img5, alphaInvisibleImgTop5, alphaLinear5, rotarLinear5,alphaMedioInvisibleImgBack5, rotar2Img5);
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