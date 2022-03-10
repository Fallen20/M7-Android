package com.example.edt02;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ForgotpasswordActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    TextView volver;

    Animation scaleDown;

    ObjectAnimator scaleLinear;
    ObjectAnimator scaleLinear2;
    ObjectAnimator alphaLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        linearLayout=findViewById(R.id.linearForgot);
        volver=findViewById(R.id.returnActivity);


        //animaciones del principio
        scaleLinear= ObjectAnimator.ofFloat(linearLayout,"scaleX",0f, 1f);
        scaleLinear2=ObjectAnimator.ofFloat(linearLayout,"scaleY",0f,  1f);//sino se pone en otra posicion
        alphaLinear=ObjectAnimator.ofFloat(linearLayout,"alpha",0f,  1f);

        scaleLinear.setStartDelay(300);
        scaleLinear2.setStartDelay(300);
        alphaLinear.setStartDelay(300);

        scaleLinear.setDuration(500);
        scaleLinear2.setDuration(500);
        alphaLinear.setDuration(500);

        AnimatorSet set=new AnimatorSet();
        set.playTogether(scaleLinear, scaleLinear2,alphaLinear);
        set.start();

        scaleDown= AnimationUtils.loadAnimation(this,R.anim.scale_down);//manera 2 con un xml

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(scaleDown);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(ForgotpasswordActivity.this, DashboardActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },1000);
            }
        });


    }
}