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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class TwoJugadorActivity extends AppCompatActivity {
    public static final String FILE_SHARE_NAME="SharedFile";

    private TextView bancaPalabra;
    private TextView puntuacionJ1;
    private TextView puntuacionJ2;
    private TextView ganadosJ1;
    private TextView ganadosJ2;

    private ImageView doubleImagen;
    private ImageView baraja;

    private Button moreJ1;
    private Button moreJ2;
    private Button stopJ1;
    private Button stopJ2;

    private ImageView carta1J1;
    private ImageView carta2J1;
    private ImageView carta3J1;
    private ImageView carta4J1;
    private ImageView carta5J1;
    private ImageView carta6J1;

    private ImageView carta1J2;
    private ImageView carta2J2;
    private ImageView carta3J2;
    private ImageView carta4J2;
    private ImageView carta5J2;
    private ImageView carta6J2;

    private Button play;
    private Button playAgain;

    private ImageView backImagen;
    private ImageView topImagen;

    private LinearLayout J1;
    private LinearLayout J2;

    private TextView Txtganador;
    private Toolbar toolbar;

    private List<Integer> imgCartasClub = new ArrayList<>();
    private List<Integer> imgCartasGold = new ArrayList<>();
    private List<Integer> imgCartasCups = new ArrayList<>();
    private List<Integer> imgCartasSword = new ArrayList<>();
    private boolean[] clubs;
    private boolean[] gold;
    private boolean[] cups;
    private boolean[] swords;
    final String imagen = "";
    final String barajaSalida = "";
    int numeroCartaJug1 = 0;
    int numeroCartaJug2 = 0;
    int J1Ganados = 0, J2Ganados = 0;
    int movJ1=80;
    int movJ2=80;

    float posicionXBank;
    float posicionYBank;
    private AtributosJugadores jugador1 = new AtributosJugadores("Player1", false, 0);
    private AtributosJugadores jugador2 = new AtributosJugadores("Player2", false, 0);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twojugador);

        //links
        backImagen = findViewById(R.id.backImage);
        topImagen = findViewById(R.id.topImagen);
        bancaPalabra = findViewById(R.id.bank);
        puntuacionJ1 = findViewById(R.id.puntuacionPlayer1);
        puntuacionJ2 = findViewById(R.id.player2Puntuacion);
        ganadosJ1 = findViewById(R.id.J1Ganados);
        ganadosJ2 = findViewById(R.id.J2Ganados);

        doubleImagen=findViewById(R.id.imagenDobleJ2);
        baraja=findViewById(R.id.barajaCartas2J);

        moreJ1 = findViewById(R.id.moreButtonPlayer1);
        stopJ1 = findViewById(R.id.stopButtonPlayer1);

        moreJ2 = findViewById(R.id.moreButtonPlayer2);
        stopJ2 = findViewById(R.id.stopButtonPlayer2);

        carta1J1 = findViewById(R.id.carta1Jug1);
        carta2J1 = findViewById(R.id.carta2Jug1);
        carta3J1 = findViewById(R.id.carta3Jug1);
        carta4J1 = findViewById(R.id.carta4Jug1);
        carta5J1 = findViewById(R.id.carta5Jug1);
        carta6J1 = findViewById(R.id.carta6Jug1);

        carta1J2 = findViewById(R.id.carta1Jug2);
        carta2J2 = findViewById(R.id.carta2Jug2);
        carta3J2 = findViewById(R.id.carta3Jug2);
        carta4J2 = findViewById(R.id.carta4Jug2);
        carta5J2 = findViewById(R.id.carta5Jug2);
        carta6J2 = findViewById(R.id.carta6Jug2);

        play = findViewById(R.id.botonPlayInicial2);
        playAgain = findViewById(R.id.buttonPlayAgain2);

        J1 = findViewById(R.id.player1PuntuacionLinear);
        J2 = findViewById(R.id.player2PuntuacionLinear);

        Txtganador = findViewById(R.id.textoGanador2);
//TOOLBAR
        toolbar= findViewById(R.id.toolbarTwoPlayer);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        arrayCartas();
        bancaPalabra.setAlpha(0);

        //RECUPERAR PUNTUACION
        //recuperar
        SharedPreferences sharedPreferences=getSharedPreferences(FILE_SHARE_NAME, Context.MODE_PRIVATE);
        String J1GanadosRecuperado=sharedPreferences.getString("J1GANADOS","0");//etiqueta, valor si no se encuentra nada
        String J2GanadosRecuperado=sharedPreferences.getString("J2GANADOS","0");//etiqueta, valor si no se encuentra nada

        //lo pones en el texto
        ganadosJ1.setText(J1GanadosRecuperado);
        ganadosJ2.setText(J2GanadosRecuperado);

        //le das el valor
        J1Ganados = Integer.parseInt(J1GanadosRecuperado);
        J2Ganados = Integer.parseInt(J2GanadosRecuperado);



        sacarAnimacionPlay();


    }

    private void sacarAnimacionPlay() {
        //ANIMACION BOTON
        //poner la palabra en su sitio



        //saca el boton
        play.setVisibility(View.VISIBLE);

        play.setScaleX(0);
        play.setScaleY(0);

        play.animate().scaleX(1).scaleY(1).setStartDelay(500).setDuration(1000).start();
        play.setClickable(true);




        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bancaPalabra.setX(topImagen.getX()+450);
                bancaPalabra.setY(topImagen.getY()+200);



                play.setVisibility(View.GONE);//desaparece


                int bancaRandom = (int) Math.floor(Math.random() * 2 + 1);
                ObjectAnimator alpha1_1 = ObjectAnimator.ofFloat(bancaPalabra, "alpha", 0f, 1f);
                ObjectAnimator alpha0_1 = ObjectAnimator.ofFloat(bancaPalabra, "alpha", 1f, 0f);
                ObjectAnimator alpha1_2 = ObjectAnimator.ofFloat(bancaPalabra, "alpha", 0f, 1f);
                ObjectAnimator alpha0_2 = ObjectAnimator.ofFloat(bancaPalabra, "alpha", 1f, 0f);
                ObjectAnimator alphaFinal = ObjectAnimator.ofFloat(bancaPalabra, "alpha", 0f, 1f);//para que se quede visible

                alpha1_1.setDuration(500);
                alpha1_2.setDuration(500);
                alpha0_1.setDuration(500);
                alpha0_2.setDuration(500);
                alphaFinal.setDuration(500);

                alpha0_1.setStartDelay(600);
                alpha1_2.setStartDelay(1200);
                alpha0_2.setStartDelay(1800);
                alphaFinal.setStartDelay(2400);

                AnimatorSet set = new AnimatorSet();
                set.playTogether(alpha1_1, alpha0_1, alpha1_2, alpha0_2, alphaFinal);
                set.start();

                topImagen.setRotationY(180);//ponla al reves
                backImagen.animate().alpha(1).setStartDelay(0).setDuration(0).start();
                topImagen.animate().alpha(0).setStartDelay(0).setDuration(0).start();



                if (bancaRandom == 1) {//J1 es la banca



                    ObjectAnimator moverAbajo = ObjectAnimator.ofFloat(bancaPalabra, "y", bancaPalabra.getY(), J1.getY());
                    moverAbajo.setDuration(1000);
                    moverAbajo.setStartDelay(3000);
                    moverAbajo.start();
                    jugador2.setHasPlayed(true);
                    jugador1.setHasPlayed(false);




                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            moverCartaJugador2(jugador2, carta1J2.getX(), numeroCartaJug2 += 1);//primera
                        }
                    }, 3500);

                } else {//J2 es la banca
                    ObjectAnimator moverArriba = ObjectAnimator.ofFloat(bancaPalabra, "y", bancaPalabra.getY(), J2.getY());
                    moverArriba.setDuration(1000);
                    moverArriba.setStartDelay(3000);
                    moverArriba.start();

                    jugador1.setHasPlayed(true);
                    jugador2.setHasPlayed(false);


                    topImagen.setRotationY(180);//ponla al reves
                    backImagen.animate().alpha(1).setStartDelay(0).setDuration(0).start();


                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            moverCartaJugador1(jugador1, carta1J1.getX(), numeroCartaJug1 += 1);//primera
                        }
                    }, 3500);


                }
            }

        });
    }

    private void moverCartaJugador1(AtributosJugadores jugador, float mover, int numero) {

        //topImagen.setAlpha(0);
        backImagen.setVisibility(View.VISIBLE);

        topImagen.setRotationY(180);//ponla al reves//ok

        //ponla en el centro
        backImagen.setX(baraja.getX());
        topImagen.setX(baraja.getX());

        topImagen.setY(baraja.getY());
        backImagen.setY(baraja.getY());

        backImagen.animate().x(mover).y(carta1J1.getTranslationY()).setStartDelay(500).setDuration(1000).start();//se mueve
        topImagen.animate().x(mover).y(carta1J1.getTranslationY()).setStartDelay(500).setDuration(1000).start();//se mueve

        elegirCarta(imagen, barajaSalida, numero, jugador);

        backImagen.animate().rotationYBy(180).alpha(0).setStartDelay(1800).setDuration(40).start();//gira
        topImagen.animate().rotationYBy(180).alpha(1).setStartDelay(1800).setDuration(90).start();//gira

    }

    private void moverCartaJugador2(AtributosJugadores jugador, float mover, int numero) {

        //topImagen.setAlpha(0);
        backImagen.setVisibility(View.VISIBLE);

        topImagen.setRotationY(180);//ponla al reves//ok

        //ponla en el centro
        backImagen.setX(baraja.getX());
        topImagen.setX(baraja.getX());

        topImagen.setY(baraja.getY());
        backImagen.setY(baraja.getY());

        backImagen.animate().x(mover).y(carta1J2.getTranslationY()).setStartDelay(500).setDuration(1000).start();//se mueve
        topImagen.animate().x(mover).y(carta1J2.getTranslationY()).setStartDelay(500).setDuration(1000).start();//se mueve

        elegirCarta(imagen, barajaSalida, numero, jugador);

        backImagen.animate().rotationYBy(180).alpha(0).setStartDelay(1800).setDuration(40).start();//gira
        topImagen.animate().rotationYBy(180).alpha(1).setStartDelay(1800).setDuration(90).start();//gira

    }


    private void elegirCarta(String imagen, String barajaSalida, int numero, AtributosJugadores jugador) {
        int baraja = (int) Math.floor(Math.random() * 4 + 1);//dime la baraja
        int random = (int) Math.floor(Math.random() * imgCartasClub.size() - 1 + 1);//saca una carta

        boolean salir = false;
        boolean llena = false;


        //cambiar imagen
        switch (baraja) {
            case 1:
                while (!salir) {
                    if (!clubs[random]) {//si no ha salido ya
                        topImagen.setImageResource(imgCartasClub.get(random));

                        imagen = getResources().getResourceEntryName(imgCartasClub.get(random));
                        barajaSalida = "clubs";

                        clubs[random] = true;//ha salido, ya no puede salir mas
                        salir = true;//sale del bucle
                    }
                    else{random = (int) Math.floor(Math.random() * imgCartasClub.size() - 1 + 1);}//me haces otro random si ya ha salido
                }

                break;

            case 2:
                while (!salir) {
                    if (!cups[random]) {//si no ha salido ya
                        topImagen.setImageResource(imgCartasCups.get(random));

                        imagen = getResources().getResourceEntryName(imgCartasCups.get(random));
                        barajaSalida = "cups";

                        cups[random] = true;//ha salido, ya no puede salir mas
                        salir = true;//sale del bucle
                    }
                    else{random = (int) Math.floor(Math.random() * imgCartasClub.size() - 1 + 1);}//me haces otro random si ya ha salido

                }

                break;

            case 3:
                while (!salir) {
                    if (!gold[random]) {//si no ha salido ya
                        topImagen.setImageResource(imgCartasGold.get(random));

                        imagen = getResources().getResourceEntryName(imgCartasGold.get(random));
                        barajaSalida = "golds";

                        gold[random] = true;//ha salido, ya no puede salir mas
                        salir = true;//sale del bucle
                    }
                    else{random = (int) Math.floor(Math.random() * imgCartasClub.size() - 1 + 1);}//me haces otro random si ya ha salido

                }

                break;

            case 4:
                while (!salir) {
                    if (!swords[random]) {//si no ha salido ya
                        topImagen.setImageResource(imgCartasSword.get(random));

                        imagen = getResources().getResourceEntryName(imgCartasSword.get(random));
                        barajaSalida = "swords";

                        swords[random] = true;//ha salido, ya no puede salir mas
                        salir = true;//sale del bucle
                    }
                    else{random = (int) Math.floor(Math.random() * imgCartasClub.size() - 1 + 1);}//me haces otro random si ya ha salido

                }
                break;
        }


        final String imagenEnvio = imagen;
        final String barajaEnvio = barajaSalida;
        final AtributosJugadores player = jugador;
        final int randomEnvio=random;

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                sumarPuntuacion(barajaEnvio, imagenEnvio, player);
                if (jugador.getNombre().equals("Player1")) {
                    ponerCartaJugador1(numero, randomEnvio, barajaEnvio);
                } else {
                    ponerCartaJugador2(numero, randomEnvio, barajaEnvio);
                }

            }
        }, 2700);//tras el giro y to do
    }

    private void sumarPuntuacion(String barajaSalida, String imagen, AtributosJugadores jugador) {
        String[] separado;
        separado = imagen.split(barajaSalida);//[1] es solo numero

        int numeroSolo = Integer.parseInt(separado[1]);
        if (numeroSolo > 7) {
            jugador.setPuntuacion(jugador.getPuntuacion() + 0.5);
        } else {
            jugador.setPuntuacion(jugador.getPuntuacion() + numeroSolo);
        }

        if (jugador.getNombre().equals("Player1")) {
            puntuacionJ1.setText(String.valueOf(jugador.getPuntuacion()));
        } else {
            puntuacionJ2.setText(String.valueOf(jugador.getPuntuacion()));
        }

        comprobar1JugadorWins(jugador);

        //para que se vuelva del color normal
        stopJ2.setBackgroundColor(getResources().getColor(R.color.colorBoton));
        stopJ1.setBackgroundColor(getResources().getColor(R.color.colorBoton));

        if (jugador.isGanar()) {
            ganar(jugador);
        } else if (jugador.isLose()) {
            perder(jugador);
        }
        else if (jugador.getNombre().equals("Player1") && !jugador.isGanar() && !jugador.isLose()) {

            if (numeroCartaJug1 <= 6) {//sale si no has ganado o si hay hueco para cartas

                moreJ1.animate().translationX(0).setDuration(800).setStartDelay(1000).start();
                stopJ1.animate().translationX(0).setDuration(800).setStartDelay(1000).start();

                moreJ1.setClickable(true);
                stopJ1.setClickable(true);


                moreJ1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        moreJ1.setClickable(false);
                        stopJ1.setClickable(false);

                        moreJ1.animate().translationX(-500).setDuration(500).setStartDelay(800).start();
                        stopJ1.animate().translationX(500).setDuration(500).setStartDelay(800).start();


                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                backImagen.animate().alpha(1).setStartDelay(0).setDuration(0).start();
                                numeroCartaJug1+=1;

                                switch (numeroCartaJug1){
                                    case 2:
                                        moverCartaJugador1(jugador,carta2J1.getX(), numeroCartaJug1);
                                        break;
                                    case 3:
                                        moverCartaJugador1(jugador,carta3J1.getX(), numeroCartaJug1);
                                        break;
                                    case 4:
                                        moverCartaJugador1(jugador,carta4J1.getX(), numeroCartaJug1);
                                        break;
                                    case 5:
                                        moverCartaJugador1(jugador,carta5J1.getX(), numeroCartaJug1);
                                        break;
                                    case 6:
                                        moverCartaJugador1(jugador,carta6J1.getX(), numeroCartaJug1);
                                        break;
                                }


                            }
                        }, 2500);//tras irse los botones


                    }
                });

                stopJ1.setOnClickListener(new View.OnClickListener() {//si paras es el turno de la banca
                    @Override
                    public void onClick(View v) {
                        moreJ1.setClickable(false);
                        stopJ1.setClickable(false);

                        moreJ1.animate().translationX(-500).setDuration(0).setStartDelay(0).start();
                        stopJ1.animate().translationX(500).setDuration(0).setStartDelay(0).start();

                        if (jugador1.isHasPlayed() == true && jugador2.isHasPlayed() == true) {
                            comprobarJugadores(jugador1, jugador2);
                        } else {
                            //activa el turno del otro

                            backImagen.animate().alpha(1).setStartDelay(0).setDuration(0).start();
                            backImagen.setX(baraja.getX());
                            topImagen.setX(baraja.getX());

                            topImagen.setY(baraja.getY());
                            backImagen.setY(baraja.getY());

                            moreJ2.animate().translationX(0).setDuration(800).setStartDelay(1000).start();
                            stopJ2.animate().translationX(0).setDuration(800).setStartDelay(1000).start();

                            moreJ2.setClickable(true);
                            stopJ2.setClickable(false);
                            stopJ2.setBackgroundColor(getResources().getColor(R.color.colorBotonOsc));

                            moreJ2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    moreJ2.setClickable(false);
                                    stopJ2.setClickable(false);

                                    moreJ2.animate().translationX(-500).setDuration(500).setStartDelay(800).start();
                                    stopJ2.animate().translationX(500).setDuration(500).setStartDelay(800).start();


                                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            jugador2.setHasPlayed(true);
                                            moverCartaJugador2(jugador2,carta1J2.getX(), numeroCartaJug2+=1);//primera
                                            //moverCartaJugador2(jugador2, cartaWidthJug2, numeroCartaJug2 += 1);


                                        }
                                    }, 2500);//tras irse los botones


                                }
                            });
                        }

                    }
                });
            } else if (numeroCartaJug1 >=7) {//si tienes 6 cartas automaticamente es el turno de la banca
                //activa el turno del otro


                if (jugador1.isHasPlayed() == true && jugador2.isHasPlayed() == true) {
                    comprobarJugadores(jugador1, jugador2);
                } else {
                    backImagen.animate().alpha(1).setStartDelay(0).setDuration(0).start();
                    backImagen.setX(baraja.getX());
                    topImagen.setX(baraja.getX());

                    topImagen.setY(baraja.getY());
                    backImagen.setY(baraja.getY());

                    moreJ2.animate().translationX(0).setDuration(800).setStartDelay(1000).start();
                    stopJ2.animate().translationX(0).setDuration(800).setStartDelay(1000).start();

                    moreJ2.setClickable(true);
                    stopJ2.setClickable(false);
                    stopJ2.setBackgroundColor(getResources().getColor(R.color.colorBotonOsc));

                    moreJ2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            moreJ2.setClickable(false);
                            stopJ2.setClickable(false);

                            moreJ2.animate().translationX(-500).setDuration(500).setStartDelay(800).start();
                            stopJ2.animate().translationX(500).setDuration(500).setStartDelay(800).start();


                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    jugador2.setHasPlayed(true);
                                    numeroCartaJug2+=1;

                                    switch (numeroCartaJug2){
                                        case 2:
                                            moverCartaJugador2(jugador2,carta2J2.getX(), numeroCartaJug2);
                                            break;
                                        case 3:
                                            moverCartaJugador2(jugador2,carta3J2.getX(), numeroCartaJug2);
                                            break;
                                        case 4:
                                            moverCartaJugador2(jugador2,carta4J2.getX(), numeroCartaJug2);
                                            break;
                                        case 5:
                                            moverCartaJugador2(jugador2,carta5J2.getX(), numeroCartaJug2);
                                            break;
                                        case 6:
                                            moverCartaJugador2(jugador2,carta6J2.getX(), numeroCartaJug2);
                                            break;
                                    }



                                }
                            }, 2500);//tras irse los botones


                        }
                    });
                }


            }
        }

        if (jugador.getNombre().equals("Player2")  && !jugador.isGanar() && !jugador.isLose()) {
            if (numeroCartaJug2 <= 6) {//sale si no has ganado o si hay hueco para cartas

                moreJ2.animate().translationX(0).setDuration(800).setStartDelay(1000).start();
                stopJ2.animate().translationX(0).setDuration(800).setStartDelay(1000).start();

                moreJ2.setClickable(true);
                stopJ2.setClickable(true);


                moreJ2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        moreJ2.setClickable(false);
                        stopJ2.setClickable(false);

                        moreJ2.animate().translationX(-500).setDuration(500).setStartDelay(800).start();
                        stopJ2.animate().translationX(500).setDuration(500).setStartDelay(800).start();


                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                backImagen.animate().alpha(1).setStartDelay(0).setDuration(0).start();
                                numeroCartaJug2+=1;

                                switch (numeroCartaJug2){
                                    case 2:
                                        moverCartaJugador2(jugador2,carta2J2.getX(), numeroCartaJug2);
                                        break;
                                    case 3:
                                        moverCartaJugador2(jugador2,carta3J2.getX(), numeroCartaJug2);
                                        break;
                                    case 4:
                                        moverCartaJugador2(jugador2,carta4J2.getX(), numeroCartaJug2);
                                        break;
                                    case 5:
                                        moverCartaJugador2(jugador2,carta5J2.getX(), numeroCartaJug2);
                                        break;
                                    case 6:
                                        moverCartaJugador2(jugador2,carta6J2.getX(), numeroCartaJug2);
                                        break;
                                }


                                //moverCartaJugador2(jugador, cartaWidthJug2, numeroCartaJug2 += 1);
                            }
                        }, 2500);//tras irse los botones


                    }
                });

                stopJ2.setOnClickListener(new View.OnClickListener() {//si paras es el turno del otro
                    @Override
                    public void onClick(View v) {

                        moreJ2.setClickable(false);
                        stopJ2.setClickable(false);

                        moreJ2.animate().translationX(-500).setDuration(0).setStartDelay(0).start();
                        stopJ2.animate().translationX(500).setDuration(0).setStartDelay(0).start();


                        //activa el turno del otro
                        if (jugador1.isHasPlayed() == true && jugador2.isHasPlayed() == true) {
                            comprobarJugadores(jugador1, jugador2);
                        } else {
                            //cuando le apretas a stop salen los botones del otro

                            backImagen.animate().alpha(1).setStartDelay(0).setDuration(0).start();
                            backImagen.setX(baraja.getX());
                            topImagen.setX(baraja.getX());

                            topImagen.setY(baraja.getY());
                            backImagen.setY(baraja.getY());

                            moreJ1.animate().translationX(0).setDuration(800).setStartDelay(1000).start();
                            stopJ1.animate().translationX(0).setDuration(800).setStartDelay(1000).start();

                            moreJ1.setClickable(true);
                            stopJ1.setClickable(false);
                            stopJ1.setBackgroundColor(getResources().getColor(R.color.colorBotonOsc));//cambias el color

                            moreJ1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    moreJ1.setClickable(false);
                                    stopJ1.setClickable(false);

                                    moreJ1.animate().translationX(-500).setDuration(500).setStartDelay(800).start();
                                    stopJ1.animate().translationX(500).setDuration(500).setStartDelay(800).start();


                                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            jugador1.setHasPlayed(true);
                                            moverCartaJugador1(jugador1,carta1J1.getX(), numeroCartaJug1+=1);//primera
                                            //moverCartaJugador1(jugador1, cartaWidthJug1, numeroCartaJug1 += 1);
                                        }
                                    }, 2500);//tras irse los botones


                                }
                            });

                        }
                    }

                });

            } else if (numeroCartaJug2 >= 7) {//si tienes 6 cartas automaticamente es el turno del otro
                //activa el turno del otro

                if (jugador1.isHasPlayed() == true && jugador2.isHasPlayed() == true) {
                    comprobarJugadores(jugador1, jugador2);
                } else {
                    backImagen.animate().alpha(1).setStartDelay(0).setDuration(0).start();
                    backImagen.setX(baraja.getX());
                    topImagen.setX(baraja.getX());

                    topImagen.setY(baraja.getY());
                    backImagen.setY(baraja.getY());


                    moreJ1.animate().translationX(0).setDuration(800).setStartDelay(1000).start();
                    stopJ1.animate().translationX(0).setDuration(800).setStartDelay(1000).start();

                    moreJ1.setClickable(true);
                    stopJ1.setClickable(false);
                    stopJ1.setBackgroundColor(getResources().getColor(R.color.colorBotonOsc));//cambias el color

                    moreJ1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            moreJ1.setClickable(false);
                            stopJ1.setClickable(false);

                            moreJ1.animate().translationX(-500).setDuration(500).setStartDelay(800).start();
                            stopJ1.animate().translationX(500).setDuration(500).setStartDelay(800).start();


                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    jugador1.setHasPlayed(true);
                                    numeroCartaJug1+=1;

                                    switch (numeroCartaJug1){
                                        case 2:
                                            moverCartaJugador1(jugador,carta2J1.getX(), numeroCartaJug1);
                                            break;
                                        case 3:
                                            moverCartaJugador1(jugador,carta3J1.getX(), numeroCartaJug1);
                                            break;
                                        case 4:
                                            moverCartaJugador1(jugador,carta4J1.getX(), numeroCartaJug1);
                                            break;
                                        case 5:
                                            moverCartaJugador1(jugador,carta5J1.getX(), numeroCartaJug1);
                                            break;
                                        case 6:
                                            moverCartaJugador1(jugador,carta6J1.getX(), numeroCartaJug1);
                                            break;
                                    }


                                    //moverCartaJugador1(jugador1, cartaWidthJug1, numeroCartaJug1 += 1);


                                }
                            }, 2500);//tras irse los botones


                        }
                    });
                }


            }
        }

    }

    private void comprobarJugadores(AtributosJugadores jugador1, AtributosJugadores jugador2) {

        if (jugador1.getPuntuacion() != 0 && jugador2.getPuntuacion() != 0) {
            //solo comprueba si no es 0 (aka ambos han de tener cartas)

            if (Math.abs(jugador2.getPuntuacion() - 7.5) < Math.abs(jugador1.getPuntuacion() - 7.5)) {
                //Toast.makeText(getApplicationContext(), "j2 esta mas cerca", Toast.LENGTH_SHORT).show();
                ganar(jugador2);
            } else if (jugador2.getPuntuacion() == jugador1.getPuntuacion()) {
                empate();
            } else {
                ganar(jugador1);
                //Toast.makeText(getApplicationContext(), "j1 esta mas cerca", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void comprobar1JugadorWins(AtributosJugadores jugador) {
        if (jugador.getPuntuacion() == 7.5) {
            jugador.setGanar(true);
        }

        if (jugador.getPuntuacion() > 7.5) {
            jugador.setLose(true);
        }
    }


    //----------------------
    private void ganar(AtributosJugadores jugador) {
        Txtganador.setVisibility(View.VISIBLE);
        Txtganador.setScaleX(0);//al principio es peque
        Txtganador.setScaleY(0);

        Txtganador.animate().scaleX(1).scaleY(1).setStartDelay(500).setDuration(1000).start();
        Txtganador.setText(jugador.getNombre() + " has won!");

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if (jugador.getNombre().equals("Player2")) {
                    ganaJ2();
                } else {
                    ganaJ1();
                }

                sacarBotonAgain();
            }
        }, 1500);
    }


    private void perder(AtributosJugadores jugador) {
        Txtganador.setVisibility(View.VISIBLE);
        Txtganador.setScaleX(2);//al principio es grande
        Txtganador.setScaleY(2);

        Txtganador.animate().scaleX(1).scaleY(1).setStartDelay(500).setDuration(1000).start();
        Txtganador.setText(jugador.getNombre() + " have lost!");


        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if (jugador.getNombre().equals("Player1")) {
                    ganaJ2();//gana el contrario
                } else {
                    ganaJ1();
                }

                sacarBotonAgain();//independientemente de quien gane saca esto
            }
        }, 1500);

    }

    private void empate() {
        Txtganador.setVisibility(View.VISIBLE);
        Txtganador.setScaleX(2);//al principio es grande
        Txtganador.setScaleY(2);

        Txtganador.animate().scaleX(1).scaleY(1).setStartDelay(500).setDuration(1000).start();
        Txtganador.setText(R.string.draw);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                sacarBotonAgain();//independientemente de quien gane saca esto
            }
        }, 1500);

    }


    private void ganaJ1() {
        J1Ganados += 1;//primero suma
        ganadosJ1.setText(String.valueOf(J1Ganados));//se cambia el numero

        //animacion
        animacionJuegosGanados(ganadosJ1);
    }

    private void ganaJ2() {
        J2Ganados += 1;//primero suma
        ganadosJ2.setText(String.valueOf(J2Ganados));//se cambia el numero


        //animacion
        animacionJuegosGanados(ganadosJ2);

        //el animate() no funciona
    }

    private void animacionJuegosGanados(TextView ganados) {
        //actualizas la puntuacion
        SharedPreferences sharedPreferences=getSharedPreferences(FILE_SHARE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("J1GANADOS", String.valueOf(J1Ganados));
        editor.putString("J2GANADOS", String.valueOf(J2Ganados));
        editor.commit();//lo guardas


        //animacion normal
        ObjectAnimator grandeX = ObjectAnimator.ofFloat(ganados, "scaleX", 1f, 2f);
        ObjectAnimator grandeY = ObjectAnimator.ofFloat(ganados, "scaleY", 1f, 2f);
        grandeX.setDuration(700);
        grandeY.setDuration(700);
        grandeX.setStartDelay(500);
        grandeY.setStartDelay(500);

        ObjectAnimator pequeX = ObjectAnimator.ofFloat(ganados, "scaleX", 2f, 1f);
        ObjectAnimator pequeY = ObjectAnimator.ofFloat(ganados, "scaleY", 2f, 1f);
        pequeX.setDuration(700);
        pequeY.setDuration(700);
        pequeX.setStartDelay(2000);
        pequeY.setStartDelay(2000);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(grandeX, grandeY, pequeX, pequeY);
        set.start();
    }


    private void sacarBotonAgain() {
        playAgain.setVisibility(View.VISIBLE);

        playAgain.setScaleX(0);
        playAgain.setScaleY(0);
        playAgain.animate().scaleX(1).scaleY(1).setStartDelay(500).setDuration(1000).start();//hazte grande

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetearPosiciones();
            }
        });
    }

    private void resetearPosiciones() {
        //ponemos las cartas que giran en su sitio

        topImagen.setRotationY(180);//ponla al reves
        backImagen.animate().alpha(0).setStartDelay(0).setDuration(0).start();
        topImagen.animate().alpha(0).setStartDelay(0).setDuration(0).start();


        //ponla en el centro
        backImagen.setX(baraja.getX());
        topImagen.setX(baraja.getX());

        topImagen.setY(baraja.getY());
        backImagen.setY(baraja.getY());

        //quita las imagenes de las cartas
        //de la banca
        carta1J2.setImageResource(0);
        carta2J2.setImageResource(0);
        carta3J2.setImageResource(0);
        carta4J2.setImageResource(0);
        carta5J2.setImageResource(0);
        carta6J2.setImageResource(0);

        //las tuyas
        carta1J1.setImageResource(0);
        carta2J1.setImageResource(0);
        carta3J1.setImageResource(0);
        carta4J1.setImageResource(0);
        carta5J1.setImageResource(0);
        carta6J1.setImageResource(0);

        //puntuacion es ahora 0
        //el texto que sale
        puntuacionJ1.setText("0");
        puntuacionJ2.setText("0");

        //la propia puntuacion
        jugador1.setPuntuacion(0);
        jugador2.setPuntuacion(0);

        //si ha ganado o perdido
        jugador1.setGanar(false);
        jugador2.setGanar(false);

        jugador1.setLose(false);
        jugador2.setLose(false);

        jugador1.setHasPlayed(false);
        jugador2.setHasPlayed(false);

        //quita los botones y txt ganadores de ahora
        playAgain.setVisibility(View.INVISIBLE);
        Txtganador.setVisibility(View.INVISIBLE);

        //resea la carta a mover
        numeroCartaJug1 = 0;
        numeroCartaJug2 = 0;

        movJ1=80;
        movJ2=80;



        //llama a que empiece el jugador de nuevo
        arrayCartas();//resetea las cartas de nuevo

        //resetea la palabra
        bancaPalabra.setAlpha(1);//visibilidad
        bancaPalabra.setX(topImagen.getX()+450);
        bancaPalabra.setY(topImagen.getY()+200);
        sacarAnimacionPlay();
    }

    //------------------
    private void arrayCartas() {
        //garrotes
        imgCartasClub.add(0, R.drawable.clubs01);
        imgCartasClub.add(1, R.drawable.clubs02);
        imgCartasClub.add(2, R.drawable.clubs03);
        imgCartasClub.add(3, R.drawable.clubs04);
        imgCartasClub.add(4, R.drawable.clubs05);
        imgCartasClub.add(5, R.drawable.clubs06);
        imgCartasClub.add(6, R.drawable.clubs07);
        imgCartasClub.add(7, R.drawable.clubs08);
        imgCartasClub.add(8, R.drawable.clubs09);
        imgCartasClub.add(9, R.drawable.clubs10);
        imgCartasClub.add(10, R.drawable.clubs11);
        imgCartasClub.add(11, R.drawable.clubs12);

        //oros
        imgCartasGold.add(0, R.drawable.golds01);
        imgCartasGold.add(1, R.drawable.golds02);
        imgCartasGold.add(2, R.drawable.golds03);
        imgCartasGold.add(3, R.drawable.golds04);
        imgCartasGold.add(4, R.drawable.golds05);
        imgCartasGold.add(5, R.drawable.golds06);
        imgCartasGold.add(6, R.drawable.golds07);
        imgCartasGold.add(7, R.drawable.golds08);
        imgCartasGold.add(8, R.drawable.golds09);
        imgCartasGold.add(9, R.drawable.golds10);
        imgCartasGold.add(10, R.drawable.golds11);
        imgCartasGold.add(11, R.drawable.golds12);

        //copas
        imgCartasCups.add(0, R.drawable.cups01);
        imgCartasCups.add(1, R.drawable.cups02);
        imgCartasCups.add(2, R.drawable.cups03);
        imgCartasCups.add(3, R.drawable.cups04);
        imgCartasCups.add(4, R.drawable.cups05);
        imgCartasCups.add(5, R.drawable.cups06);
        imgCartasCups.add(6, R.drawable.cups07);
        imgCartasCups.add(7, R.drawable.cups08);
        imgCartasCups.add(8, R.drawable.cups09);
        imgCartasCups.add(9, R.drawable.cups10);
        imgCartasCups.add(10, R.drawable.cups11);
        imgCartasCups.add(11, R.drawable.cups12);

        //espadas
        imgCartasSword.add(0, R.drawable.swords01);
        imgCartasSword.add(1, R.drawable.swords02);
        imgCartasSword.add(2, R.drawable.swords03);
        imgCartasSword.add(3, R.drawable.swords04);
        imgCartasSword.add(4, R.drawable.swords05);
        imgCartasSword.add(5, R.drawable.swords06);
        imgCartasSword.add(6, R.drawable.swords07);
        imgCartasSword.add(7, R.drawable.swords08);
        imgCartasSword.add(8, R.drawable.swords09);
        imgCartasSword.add(9, R.drawable.swords10);
        imgCartasSword.add(10, R.drawable.swords11);
        imgCartasSword.add(11, R.drawable.swords12);


        clubs = new boolean[imgCartasClub.size()];
        gold = new boolean[imgCartasGold.size()];
        cups = new boolean[imgCartasCups.size()];
        swords = new boolean[imgCartasSword.size()];

        //lo llenas de false (por si acaso)
        for (int contador = 0; contador < clubs.length; contador++) {
            clubs[contador] = false;
            gold[contador] = false;
            cups[contador] = false;
            swords[contador] = false;
        }

    }

    private void ponerCartaJugador1(int numero, int random, String barajaSalida) {
        //numero es la posicion
        //random es el numero en la arrayy
        switch (numero) {
            case 1:
                if (barajaSalida.equals("cups")) {
                    carta1J1.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta1J1.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta1J1.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta1J1.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 2:
                if (barajaSalida.equals("cups")) {
                    carta2J1.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta2J1.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta2J1.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta2J1.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 3:
                if (barajaSalida.equals("cups")) {
                    carta3J1.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta3J1.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta3J1.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta3J1.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 4:
                if (barajaSalida.equals("cups")) {
                    carta4J1.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta4J1.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta4J1.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta4J1.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 5:
                if (barajaSalida.equals("cups")) {
                    carta5J1.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta5J1.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta5J1.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta5J1.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 6:
                if (barajaSalida.equals("cups")) {
                    carta6J1.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta6J1.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta6J1.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta6J1.setImageResource(imgCartasGold.get(random));
                }
                break;
        }

    }

    private void ponerCartaJugador2(int numero, int random, String barajaSalida) {
        //adaptarlo despues para la banca too
        //numero es la posicion
        //random es el numero en la arrayy


        switch (numero) {
            case 1:
                if (barajaSalida.equals("cups")) {
                    carta1J2.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta1J2.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta1J2.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta1J2.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 2:
                if (barajaSalida.equals("cups")) {
                    carta2J2.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta2J2.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta2J2.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta2J2.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 3:
                if (barajaSalida.equals("cups")) {
                    carta3J2.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta3J2.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta3J2.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta3J2.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 4:
                if (barajaSalida.equals("cups")) {
                    carta4J2.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta4J2.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta4J2.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta4J2.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 5:
                if (barajaSalida.equals("cups")) {
                    carta5J2.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta5J2.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta5J2.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta5J2.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 6:
                if (barajaSalida.equals("cups")) {
                    carta6J2.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta6J2.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta6J2.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta6J2.setImageResource(imgCartasGold.get(random));
                }
                break;
        }
    }

    //-----------------------------
    //TOOLBAR, MENU Y ESO
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//esto es para que salga
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);//primero el xml, luego el menu que  nos da el metodo

        return true;//true es que se ha creado
    }

}