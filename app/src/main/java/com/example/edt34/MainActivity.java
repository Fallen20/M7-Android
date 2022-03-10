package com.example.edt34;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout relativeLayout;
    private TextView txt;
    private ImageView logo;
    private ImageView fondo;

    private ObjectAnimator moverLogo;
    private ObjectAnimator alphaLogo;

    private ObjectAnimator moverTxt;
    
    private ObjectAnimator alphaFondo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //links
        relativeLayout=findViewById(R.id.relativeTxt);
        logo=findViewById(R.id.logo);
        fondo=findViewById(R.id.imgFondo);
        txt=findViewById(R.id.TxtGrande);


       //logo.setImageAlpha(0);
       // fondo.setImageAlpha(0);
       // relativeLayout.setAlpha(0);

        alphaLogo=ObjectAnimator.ofFloat(logo,"alpha",0f,1f);
        moverLogo=ObjectAnimator.ofFloat(logo,"translationX",-1000f,-2f);

        moverTxt=ObjectAnimator.ofFloat(relativeLayout,"translationX",1000f,0f);
        alphaFondo=ObjectAnimator.ofFloat(fondo,"alpha",0f,1f);

        AnimatorSet set=new AnimatorSet();

        alphaLogo.setStartDelay(500);
        moverLogo.setStartDelay(500);
        moverTxt.setStartDelay(500);
        alphaFondo.setStartDelay(1500);

        moverLogo.setDuration(1000);
        alphaLogo.setDuration(1500);
        moverTxt.setDuration(1000);
        alphaFondo.setDuration(1000);

        set.playTogether(moverLogo,alphaLogo,moverTxt,alphaFondo);
        set.start();

        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(logo,"imgTrans");
                pairs[1] = new Pair<View,String>(txt,"textoTrans");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        MainActivity.this,
                        pairs[0],
                        pairs[1]
                );
                Intent intent=new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(intent,options.toBundle());
            }
        });

    }
}