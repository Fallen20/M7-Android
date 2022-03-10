package com.example.edt02;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    LinearLayout linear;
    TextView newUser;
    TextView passWord;
    Button logIn;

    ObjectAnimator scaleLinear;
    ObjectAnimator scaleLinear2;
    ObjectAnimator alphaLinear;

    Animation scaleDown;
    ObjectAnimator agrandarXTxt;
    ObjectAnimator agrandarYTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        linear=findViewById(R.id.layoutMedio);
        newUser=findViewById(R.id.newUser);
        passWord=findViewById(R.id.forgotPass);
        logIn=findViewById(R.id.logInButton);


        //animaciones del principio
        scaleLinear=ObjectAnimator.ofFloat(linear,"scaleX",0f, 1f);
        scaleLinear2=ObjectAnimator.ofFloat(linear,"scaleY",0f,  1f);//sino se pone en otra posicion
        alphaLinear=ObjectAnimator.ofFloat(linear,"alpha",0f,  1f);

        scaleLinear.setStartDelay(800);
        scaleLinear2.setStartDelay(800);
        alphaLinear.setStartDelay(800);

        scaleLinear.setDuration(800);
        scaleLinear2.setDuration(800);
        alphaLinear.setDuration(800);

        AnimatorSet set=new AnimatorSet();
        set.playTogether(scaleLinear, scaleLinear2,alphaLinear);
        set.start();

        //scaleDown=AnimationUtils.loadAnimation(this,R.anim.scale_down);//manera 2 con un xml

        //CONTRASEÑA
        passWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                agrandarXTxt=ObjectAnimator.ofFloat(view,"scaleX",0.6f, 1f);
                agrandarYTxt=ObjectAnimator.ofFloat(view,"scaleY",0.6f,  1f);//sino se pone en otra posicion

                agrandarXTxt.setStartDelay(300);
                agrandarYTxt.setStartDelay(300);

                agrandarXTxt.setDuration(500);
                agrandarYTxt.setDuration(500);

                AnimatorSet set=new AnimatorSet();
                set.playTogether(agrandarXTxt, agrandarYTxt);
                set.start();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent=new Intent(DashboardActivity.this, ForgotpasswordActivity.class);
                        startActivity(intent);
                    }
                }, 1000);//esto es para ponerle un delay tras apretar



                ///passWord.startAnimation(scaleDown);//manera 2 con xml

            }
        });


        ///NEW USER
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                agrandarXTxt=ObjectAnimator.ofFloat(view,"scaleX",0.6f, 1f);
                agrandarYTxt=ObjectAnimator.ofFloat(view,"scaleY",0.6f,  1f);//sino se pone en otra posicion

                agrandarXTxt.setStartDelay(100);
                agrandarYTxt.setStartDelay(100);

                agrandarXTxt.setDuration(500);
                agrandarYTxt.setDuration(500);

                AnimatorSet set=new AnimatorSet();
                set.playTogether(agrandarXTxt, agrandarYTxt);
                set.start();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent=new Intent(DashboardActivity.this, SignupActivity.class);
                        startActivity(intent);
                    }
                }, 1000);//esto es para ponerle un delay tras apretar


            }
        });

    }
}