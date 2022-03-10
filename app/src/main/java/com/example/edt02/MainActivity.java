package com.example.edt02;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imagenBiciInicio;
    TextView titulo1;
    TextView titulo2;


    ObjectAnimator biciAnimationRotation;
    ObjectAnimator biciAnimationMover;
    ObjectAnimator biciAnimationAlpha;


    ObjectAnimator texto1Rotation;
    ObjectAnimator texto1Mover;
    ObjectAnimator texto1Alpha;


    ObjectAnimator texto2Rotation;
    ObjectAnimator texto2Mover;
    ObjectAnimator texto2Alpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagenBiciInicio=findViewById(R.id.biciDegradado);
        titulo1=findViewById(R.id.titulo1);
        titulo2=findViewById(R.id.titulo2);

        biciAnimationRotation=ObjectAnimator.ofFloat(imagenBiciInicio, "rotation",-0f,+360f);
        biciAnimationMover=ObjectAnimator.ofFloat(imagenBiciInicio, "translationY",-1500f, 100f);
        biciAnimationAlpha=ObjectAnimator.ofFloat(imagenBiciInicio, "alpha",0f, 1f);

        texto1Rotation=ObjectAnimator.ofFloat(titulo1,"rotation", 0f, -360f);
        texto1Mover=ObjectAnimator.ofFloat(titulo1,"translationY", 1500f, 0f);
        texto1Alpha=ObjectAnimator.ofFloat(titulo1,"alpha", 0f, 1f);

        texto2Rotation=ObjectAnimator.ofFloat(titulo2,"rotation", 0f, -360f);
        texto2Mover=ObjectAnimator.ofFloat(titulo2,"translationY", 1500f, 150f);
        texto2Alpha=ObjectAnimator.ofFloat(titulo2,"alpha", 0f, 1f);

        AnimatorSet set=new AnimatorSet();

        biciAnimationRotation.setStartDelay(500);
        biciAnimationMover.setStartDelay(500);
        biciAnimationAlpha.setStartDelay(500);

        texto1Rotation.setStartDelay(1000);
        texto1Mover.setStartDelay(1000);
        texto1Alpha.setStartDelay(1000);

        texto2Rotation.setStartDelay(1000);
        texto2Mover.setStartDelay(1000);
        texto2Alpha.setStartDelay(1000);

        biciAnimationMover.setDuration(1500);
        biciAnimationRotation.setDuration(1500);
        biciAnimationAlpha.setDuration(1500);

        texto1Rotation.setDuration(1000);
        texto1Mover.setDuration(1000);
        texto1Alpha.setDuration(1000);

        texto2Rotation.setDuration(900);
        texto2Mover.setDuration(900);
        texto2Alpha.setDuration(900);

        set.playTogether(biciAnimationAlpha,biciAnimationMover, biciAnimationRotation,
                        texto1Rotation,texto1Mover,texto1Alpha,
                        texto2Rotation,texto2Mover, texto2Alpha);

        set.start();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(MainActivity.this, DashboardActivity.class);

                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
                    Pair[] pairs=new Pair[2];//num de cosas que movemos
                    pairs[0]=new Pair<View, String>(imagenBiciInicio,"biciTranslation");
                    pairs[1]=new Pair<View, String>(titulo1,"textoTranslation");


                    ActivityOptions option=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                    //lo de arriba es necesario para pasar las cosas de arriba a la misma posicion que el otro
                    //o algo asi idk

                    startActivity(intent, option.toBundle());//inicia esto
                    finish();

                }
            }
        }, 2500);//poner esto al final es el delay
//el txt empieza mas tarde


    }
}