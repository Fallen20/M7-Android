package com.example.sevenhalf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   // private LinearLayout logo;
    //private ImageView logoBG;
    private ImageView logo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //links
        logo=findViewById(R.id.logoMain);


        //ANIMACION PRINCIPIO LOGO
        logo.animate().rotationBy(360).setDuration(2000).setStartDelay(500).start();//gira
       // logo.animate().scaleXBy(4).scaleYBy(4).x(900).setDuration(2000).setStartDelay(2500).x(900).start();//zoom y centrar 7


        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, SeleccionActivity.class);

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                            MainActivity.this,
                            Pair.create(logo, logo.getTransitionName())
                    );
                    startActivity(intent,options.toBundle());
                    finish();
                }
            }
        }, 3000);//tras irse los botones


    }



}