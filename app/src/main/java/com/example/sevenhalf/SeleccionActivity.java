package com.example.sevenhalf;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SeleccionActivity extends AppCompatActivity {

    public static final String FILE_SHARE_NAME="SharedFile";//lo creas aqui
    SharedPreferences sharedPreferences;//para acceder


    private Button Oneplayer;
    private Button Twoplayer;
    private Button resumeGame;
    private Button newGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);


        Oneplayer = findViewById(R.id.One_player);
        Twoplayer = findViewById(R.id.Two_player);
        resumeGame = findViewById(R.id.resumeButton);
        newGame = findViewById(R.id.newButton);

        onStart();


        //ANIMACION BOTONES INICIO

       /* ObjectAnimator translationOne=ObjectAnimator.ofFloat(Oneplayer,"translationX",-1000f,0f);
        ObjectAnimator translationTwo=ObjectAnimator.ofFloat(Twoplayer,"translationX",1000f,0f);

        translationOne.setStartDelay(500);
        translationTwo.setStartDelay(500);

        translationOne.setDuration(1000);
        translationTwo.setDuration(1000);

        AnimatorSet set=new AnimatorSet();
        set.playTogether(translationOne, translationTwo);
        set.start();*/

        //AL HACER CLICK

        //ERROR --------------
        //CUANDO VAS PARA ATRAS NO SA SALEN LOS BOTONES Y POR ELLO NO PUEDES APRETAR A NUEVA/REANUDAR PARTIDA O ALGO

        Oneplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moverBotonesInverso1Jugador();
            }
        });

        Twoplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moverBotonesInverso2Jugador();
            }//esto ha de llevar a otra actividad
        });
    }

    @Override
    protected void onStart(){//cuando abres esto (por ir para atras o la primera vez) hace esto
        super.onStart();

        //para que no se pueda clickar mientras se mueven
        Oneplayer.setClickable(false);
        Twoplayer.setClickable(false);

        Oneplayer.animate().translationX(0).setStartDelay(500).setDuration(1000).start();
        Twoplayer.animate().translationX(0).setStartDelay(500).setDuration(1000).start();

        //pueden apretarse tras moverse
        Oneplayer.setClickable(true);
        Twoplayer.setClickable(true);

    }

    private void moverBotonesInverso1Jugador() {
        sharedPreferences=getSharedPreferences(FILE_SHARE_NAME, Context.MODE_PRIVATE);//para acceder

        //SE VAN LOS BOTONES
        ObjectAnimator translationOne=ObjectAnimator.ofFloat(Oneplayer,"translationX",0f,-1000f);
        ObjectAnimator translationTwo=ObjectAnimator.ofFloat(Twoplayer,"translationX",0f,1000f);
        translationOne.setStartDelay(500);
        translationTwo.setStartDelay(500);

        translationOne.setDuration(1000);
        translationTwo.setDuration(1000);

        AnimatorSet set=new AnimatorSet();
        set.playTogether(translationOne, translationTwo);
        set.start();

        //para que no se pueda clicar tras mover
        Oneplayer.setClickable(false);
        Twoplayer.setClickable(false);

//recuperar
        String JGanadosRecuperado=sharedPreferences.getString("JGANADOS","0");//etiqueta - valor si no hay
        String BGanadosRecuperado=sharedPreferences.getString("BGANADOS","0");

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if(Integer.parseInt(JGanadosRecuperado)>0 || Integer.parseInt(BGanadosRecuperado)>0){//aka se ha jugado antes

                    resumeGame.animate().translationX(0).setStartDelay(500).setDuration(1000).start();
                    newGame.animate().translationX(0).setStartDelay(500).setDuration(1000).start();


                    resumeGame.setClickable(true);
                    newGame.setClickable(true);

                    resumeGame.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            resumeGame.animate().translationX(-1000).setStartDelay(500).setDuration(1000).start();
                            newGame.animate().translationX(1000).setStartDelay(500).setDuration(1000).start();

                            resumeGame.setClickable(false);
                            newGame.setClickable(false);

                            Intent intent = new Intent(getApplicationContext(), UnJugadorActivity.class);
                            startActivity(intent);
                        }
                    });


                    newGame.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            resumeGame.animate().translationX(-1000).setStartDelay(500).setDuration(1000).start();
                            newGame.animate().translationX(1000).setStartDelay(500).setDuration(1000).start();

                            resumeGame.setClickable(false);
                            newGame.setClickable(false);

                            //borras lo anterior
                            SharedPreferences.Editor editor= sharedPreferences.edit();
                            editor.putString("JGANADOS", "0");
                            editor.putString("BGANADOS", "0");
                            editor.commit();//lo guardas

                            Intent intent = new Intent(getApplicationContext(), UnJugadorActivity.class);
                            startActivity(intent);
                        }
                    });
                }
                else{//sino se ha jugado antes solo empieza uno
                    //escribes un 0
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString("JGANADOS", "0");
                    editor.putString("BGANADOS", "0");
                    editor.commit();//lo guardas

                    Intent intent = new Intent(getApplicationContext(), UnJugadorActivity.class);
                    startActivity(intent);
                }
            }

        }, 1500);//tras irse los botones


    }

    private void moverBotonesInverso2Jugador() {
        sharedPreferences=getSharedPreferences(FILE_SHARE_NAME, Context.MODE_PRIVATE);//para acceder


        ObjectAnimator translationOne = ObjectAnimator.ofFloat(Oneplayer, "translationX", 0f, -1000f);
        ObjectAnimator translationTwo = ObjectAnimator.ofFloat(Twoplayer, "translationX", 0f, 1000f);
        translationOne.setStartDelay(500);
        translationTwo.setStartDelay(500);

        translationOne.setDuration(1000);
        translationTwo.setDuration(1000);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(translationOne, translationTwo);
        set.start();

///leer
        String J1GanadosRecuperado=sharedPreferences.getString("J1GANADOS","0");//etiqueta - valor
        String J2GanadosRecuperado=sharedPreferences.getString("J2GANADOS","0");

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if(Integer.parseInt(J1GanadosRecuperado)!=0 || Integer.parseInt(J2GanadosRecuperado)!=0){//aka se ha jugado antes

                    resumeGame.animate().translationX(0).setStartDelay(500).setDuration(1000).start();
                    newGame.animate().translationX(0).setStartDelay(500).setDuration(1000).start();

                    resumeGame.setClickable(true);
                    newGame.setClickable(true);

                    resumeGame.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            resumeGame.animate().translationX(-1000).setStartDelay(500).setDuration(1000).start();
                            newGame.animate().translationX(1000).setStartDelay(500).setDuration(1000).start();

                            resumeGame.setClickable(false);
                            newGame.setClickable(false);

                            //le envias lo que tienes guardado
                            Intent intent = new Intent(getApplicationContext(), TwoJugadorActivity.class);
                            startActivity(intent);
                        }
                    });


                    newGame.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            resumeGame.animate().translationX(-1000).setStartDelay(500).setDuration(1000).start();
                            newGame.animate().translationX(1000).setStartDelay(500).setDuration(1000).start();

                            resumeGame.setClickable(false);
                            newGame.setClickable(false);

                            //borras lo anterior
                            SharedPreferences.Editor editor= sharedPreferences.edit();
                            editor.putString("J1GANADOS", "0");
                            editor.putString("J2GANADOS", "0");
                            editor.commit();//lo guardas

                            Intent intent = new Intent(getApplicationContext(), TwoJugadorActivity.class);
                            startActivity(intent);
                        }
                    });
                }
                else{//sino se ha jugado antes solo empieza uno
                    //borras lo anterior
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString("J1GANADOS", "0");
                    editor.putString("J2GANADOS", "0");
                    editor.commit();//lo guardas

                    Intent intent = new Intent(getApplicationContext(), TwoJugadorActivity.class);
                    startActivity(intent);
                }
            }

        }, 1500);//tras irse los botones



        /*new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), TwoJugadorActivity.class);
                startActivity(intent);
            }
        }, 1500);
*/



    }
}