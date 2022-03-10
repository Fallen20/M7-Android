package com.example.sevenhalf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UnJugadorActivity extends AppCompatActivity {

    public static final String FILE_SHARE_NAME="SharedFile";//lo creas aqui

    //accedes al doc con la info

    private Button botonPlay1;
    private ImageView backImagen;
    private ImageView topImagen;
    private ImageView doubleImagen;
    private ImageView baraja;
    private TextView puntuacionJugador;
    private TextView puntuacionBanca;
    private TextView ganadosBanca;
    private TextView ganadosJugador;
    private Button botonMore;
    private Button botonStop;

    private ImageView carta1You;
    private ImageView carta2You;
    private ImageView carta3You;
    private ImageView carta4You;
    private ImageView carta5You;
    private ImageView carta6You;
    private ImageView carta1Banca;
    private ImageView carta2Banca;
    private ImageView carta3Banca;
    private ImageView carta4Banca;
    private ImageView carta5Banca;
    private ImageView carta6Banca;

    private Button playAgain;
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
    int numeroCarta = 2;
    int numeroCartaBanca = 2;
    int JGanados = 0, BGanados = 0;

    int mov=80;
    int movBanca=80;


    private AtributosJugadores jugador1 = new AtributosJugadores("You", false, 0);
    private AtributosJugadores banca = new AtributosJugadores("Bank", false, 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unjugador);

        //links
        botonPlay1 = findViewById(R.id.botonPlayInicial);
        backImagen = findViewById(R.id.backImage);
        topImagen = findViewById(R.id.topImagen);
        baraja = findViewById(R.id.barajaCartas);
        puntuacionJugador = findViewById(R.id.puntuacionPlayer1);
        puntuacionBanca = findViewById(R.id.bankPuntuacion);
        botonMore = findViewById(R.id.moreButton);
        botonStop = findViewById(R.id.stopButton);

        carta1You = findViewById(R.id.carta1You);
        carta2You = findViewById(R.id.carta2You);
        carta3You = findViewById(R.id.carta3You);
        carta4You = findViewById(R.id.carta4You);
        carta5You = findViewById(R.id.carta5You);
        carta6You = findViewById(R.id.carta6You);
        carta1Banca = findViewById(R.id.carta1Banca);
        carta2Banca = findViewById(R.id.carta2Banca);
        carta3Banca = findViewById(R.id.carta3Banca);
        carta4Banca = findViewById(R.id.carta4Banca);
        carta5Banca = findViewById(R.id.carta5Banca);
        carta6Banca = findViewById(R.id.carta6Banca);

        Txtganador = findViewById(R.id.textoGanador);
        playAgain = findViewById(R.id.buttonPlayAgain);

        ganadosBanca = findViewById(R.id.bankGanados);
        ganadosJugador = findViewById(R.id.youGanados);

        //TOOLABAR
        toolbar=findViewById(R.id.toolbarOnePlayer);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //RECUPERAR PUNTUACION
        //recuperar
        SharedPreferences sharedPreferences=getSharedPreferences(FILE_SHARE_NAME, Context.MODE_PRIVATE);
        String JGanadosRecuperado=sharedPreferences.getString("JGANADOS","0");//etiqueta, valor si no se encuentra nada
        String BGanadosRecuperado=sharedPreferences.getString("BGANADOS","0");//etiqueta, valor si no se encuentra nada

        //lo pones en el texto
        ganadosJugador.setText(JGanadosRecuperado);
        ganadosBanca.setText(BGanadosRecuperado);

        //lo pones como puntuacion
        JGanados = Integer.parseInt(JGanadosRecuperado);
        BGanados = Integer.parseInt(BGanadosRecuperado);


        botonPlay1.setClickable(false);
        botonMore.setClickable(false);
        botonStop.setClickable(false);


        arrayCartas();

        //ANIMACION BOTON
        botonPlay1.setScaleX(0);
        botonPlay1.setScaleY(0);

        botonPlay1.animate().scaleX(1).scaleY(1).setStartDelay(500).setDuration(1000).start();
        botonPlay1.setClickable(true);

        botonPlay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botonPlay1.setVisibility(View.GONE);//desaparece

                moverCartaJugador(jugador1,carta1You.getX(), 1);//primera

            }

        });

    }

    private void moverCartaJugador(AtributosJugadores jugador, float mover, int numero) {//mueve las cartas pero de la banca

        //topImagen.setAlpha(0);
        backImagen.setVisibility(View.VISIBLE);

        topImagen.setRotationY(180);//ponla al reves//ok

        //ponla en el centro
        backImagen.setX(baraja.getX());
        topImagen.setX(baraja.getX());

        topImagen.setY(baraja.getY());
        backImagen.setY(baraja.getY());

        //calcular la nueva posicion
        //float moverFinale = mov + mover;

        backImagen.animate().x(mover).y(carta1You.getTranslationY()).setStartDelay(500).setDuration(1000).start();//se mueve
        topImagen.animate().x(mover).y(carta1You.getTranslationY()).setStartDelay(500).setDuration(1000).start();//se mueve

        elegirCarta(imagen, barajaSalida, numero, jugador);

        backImagen.animate().rotationYBy(180).alpha(0).setStartDelay(1800).setDuration(40).start();//gira
        topImagen.animate().rotationYBy(180).alpha(1).setStartDelay(1800).setDuration(90).start();//gira

    }

    private void moverCartaBanca(AtributosJugadores jugador,float mover, int numero) {

        //topImagen.setAlpha(0);
        backImagen.setVisibility(View.VISIBLE);

        topImagen.setRotationY(180);//ponla al reves//ok

        //ponla en el centro
        backImagen.setX(baraja.getX());
        topImagen.setX(baraja.getX());

        topImagen.setY(baraja.getY());
        backImagen.setY(baraja.getY());

        //calcular la nueva posicion
       //float moverFinale = mov + mover;

        //mas bajo Y: arriba
        backImagen.animate().x(mover).y(carta1Banca.getTranslationY()).setStartDelay(500).setDuration(1000).start();//se mueve
        topImagen.animate().x(mover).y(carta1Banca.getTranslationY()).setStartDelay(500).setDuration(1000).start();//se mueve

        elegirCarta(imagen, barajaSalida, numero, jugador);

        backImagen.animate().rotationYBy(180).alpha(0).setStartDelay(1800).setDuration(40).start();//gira
        topImagen.animate().rotationYBy(180).alpha(1).setStartDelay(1800).setDuration(90).start();//gira

        comprobar1JugadorWins(jugador);

        if (jugador.isGanar()) {
            ganar(jugador);
        } else if (jugador.isLose()) {
            perder(jugador);
        }

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

        if (jugador.getNombre().equals("You")) {
            puntuacionJugador.setText(String.valueOf(jugador.getPuntuacion()));
        } else {
            puntuacionBanca.setText(String.valueOf(jugador.getPuntuacion()));
        }

        comprobar1JugadorWins(jugador);


        if (jugador.isGanar()) {
            ganar(jugador);
        } else if (jugador.isLose()) {
            perder(jugador);
        } else if (numeroCarta <=6 && jugador.getNombre().equals("You")) {//sale si no se ha ganado o si hay hueco para cartas


            botonMore.animate().translationX(0).setDuration(800).setStartDelay(1000).start();
            botonStop.animate().translationX(0).setDuration(800).setStartDelay(1000).start();

            botonMore.setClickable(true);
            botonStop.setClickable(true);


            botonMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    botonMore.setClickable(false);
                    botonStop.setClickable(false);

                    botonMore.animate().translationX(-500).setDuration(500).setStartDelay(800).start();
                    botonStop.animate().translationX(500).setDuration(500).setStartDelay(800).start();




                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            backImagen.animate().alpha(1).setStartDelay(0).setDuration(0).start();


                            switch (numeroCarta){
                                case 2:
                                    moverCartaJugador(jugador,carta2You.getX(), numeroCarta);
                                    break;
                                case 3:
                                    moverCartaJugador(jugador,carta3You.getX(), numeroCarta);
                                    break;
                                case 4:
                                    moverCartaJugador(jugador,carta4You.getX(), numeroCarta);
                                    break;
                                case 5:
                                    moverCartaJugador(jugador,carta5You.getX(), numeroCarta);
                                    break;
                                case 6:
                                    moverCartaJugador(jugador,carta6You.getX(), numeroCarta);
                                    break;
                            }

                            numeroCarta+=1;

                        }
                    }, 2500);//tras irse los botones


                }
            });

            botonStop.setOnClickListener(new View.OnClickListener() {//si paras es el turno de la banca
                @Override
                public void onClick(View v) {
                    botonMore.setClickable(false);
                    botonStop.setClickable(false);

                    botonMore.animate().translationX(-500).setDuration(0).setStartDelay(0).start();
                    botonStop.animate().translationX(500).setDuration(0).setStartDelay(0).start();


                    //activa el turno del otro

                    backImagen.animate().alpha(1).setStartDelay(0).setDuration(0).start();
                    moverCartaBanca(banca,carta1Banca.getX(),  1);//primera vez
                }
            });
        } else if (numeroCarta >=7  && jugador.getNombre().equals("You")) {//si tienes 6 cartas automaticamente es el turno de la banca
            //activa el turno del otro
            backImagen.animate().alpha(1).setStartDelay(0).setDuration(0).start();
            moverCartaBanca(banca,carta1Banca.getX(),  1);//primera vez

        } else if (jugador.getNombre().equals("Bank")) {
            if (jugador.getPuntuacion() == 0) {//para el reset, que siempre pille una carta
                moverCartaBanca(banca, carta1Banca.getX(), 1);//primera vez
            }
            if (jugador.getPuntuacion() < 7.5 && numeroCartaBanca >= 7) {//si la banca no llega a 7.5 pero tiene 6 cartas
                comprobarJugadores(jugador1, banca);
            } else if (jugador.getPuntuacion() < 7.5) {//si la banca no llega a 7.5

                if (jugador.getPuntuacion() <= jugador1.getPuntuacion() && numeroCartaBanca <= 6) {//si puedes superarlo todavia y puede robar cartas
                    backImagen.animate().alpha(1).setStartDelay(0).setDuration(0).start();//ponla al reves

                    switch (numeroCartaBanca){
                        case 2:
                            moverCartaBanca(jugador,carta2Banca.getX(), numeroCartaBanca);
                            break;
                        case 3:
                            moverCartaBanca(jugador,carta3Banca.getX(), numeroCartaBanca);
                            break;
                        case 4:
                            moverCartaBanca(jugador,carta4Banca.getX(), numeroCartaBanca);
                            break;
                        case 5:
                            moverCartaBanca(jugador,carta5Banca.getX(), numeroCartaBanca);
                            break;
                        case 6:
                            moverCartaBanca(jugador,carta6Banca.getX(), numeroCartaBanca);
                            break;
                    }
                    numeroCartaBanca+=1;//2+1 para la siguiente

                } else {
                    comprobarJugadores(jugador1, banca);
                }
            } else {//si no llega a 7.5 pero no puede hacer nada
                comprobarJugadores(jugador1, banca);
            }

        }
    }

    //-------------------------
    private void comprobarJugadores(AtributosJugadores jugador1, AtributosJugadores banca) {

        if(jugador1.getPuntuacion()!=0 && banca.getPuntuacion()!=0){
            //solo comprueba si no es 0 (aka ambos han de tener cartas)

            if (banca.getPuntuacion() == 7.5) {
                ganar(banca);
            } else if (jugador1.getPuntuacion() == 7.5) {
                ganar(jugador1);
            } else if (banca.getPuntuacion() > 7.5) {
                perder(banca);
            }
            else if (Math.abs(banca.getPuntuacion() - 7.5) < Math.abs(jugador1.getPuntuacion() - 7.5)) {
                //Toast.makeText(getApplicationContext(), "Banca esta mas cerca", Toast.LENGTH_SHORT).show();
                ganar(banca);
            }
            else if(banca.getPuntuacion()==jugador1.getPuntuacion()){
                empate();
            }
            else {
                ganar(jugador1);
                //Toast.makeText(getApplicationContext(), "Jugador esta mas cerca", Toast.LENGTH_SHORT).show();
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

    //-----------------

    private void ganar(AtributosJugadores jugador) {
        Txtganador.setVisibility(View.VISIBLE);
        Txtganador.setScaleX(0);//al principio es peque
        Txtganador.setScaleY(0);

        Txtganador.animate().scaleX(1).scaleY(1).setStartDelay(500).setDuration(1000).start();
        Txtganador.setText(jugador.getNombre() + " has won!");

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if (jugador.getNombre().equals("Bank")) {
                    ganaBanca();
                } else {
                    ganaJugador();
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
                if (jugador.getNombre().equals("Bank")) {
                    ganaJugador();
                } else {
                    ganaBanca();
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


    private void ganaJugador() {
        JGanados += 1;//primero suma
        ganadosJugador.setText(String.valueOf(JGanados));//se cambia el numero

        //animacion
        animacionJuegosGanados(ganadosJugador);
   }

    private void ganaBanca() {
        BGanados += 1;//primero suma
        ganadosBanca.setText(String.valueOf(BGanados));//se cambia el numero


        //animacion
        animacionJuegosGanados(ganadosBanca);

        //el animate() no funciona
    }

    private void animacionJuegosGanados(TextView ganados) {

        //escribir el resultado nuevo
        SharedPreferences sharedPreferences=getSharedPreferences(FILE_SHARE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("BGANADOS", String.valueOf(BGanados));
        editor.putString("JGANADOS", String.valueOf(JGanados));
        editor.commit();//lo guardas


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
        backImagen.animate().alpha(1).setStartDelay(0).setDuration(0).start();

        //ponla en el centro
        backImagen.setX(baraja.getX());
        topImagen.setX(baraja.getX());

        topImagen.setY(baraja.getY());
        backImagen.setY(baraja.getY());

        //quita las imagenes de las cartas
        //de la banca
        carta1Banca.setImageResource(0);
        carta2Banca.setImageResource(0);
        carta3Banca.setImageResource(0);
        carta4Banca.setImageResource(0);
        carta5Banca.setImageResource(0);
        carta6Banca.setImageResource(0);

        //las tuyas
        carta1You.setImageResource(0);
        carta2You.setImageResource(0);
        carta3You.setImageResource(0);
        carta4You.setImageResource(0);
        carta5You.setImageResource(0);
        carta6You.setImageResource(0);

        //puntuacion es ahora 0
        //el texto que sale
        puntuacionBanca.setText("0");
        puntuacionJugador.setText("0");

        //la propia puntuacion
        jugador1.setPuntuacion(0);
        banca.setPuntuacion(0);

        //si ha ganado o perdido
        jugador1.setGanar(false);
        banca.setGanar(false);

        jugador1.setLose(false);
        banca.setLose(false);

        //quita los botones y txt ganadores de ahora
        playAgain.setVisibility(View.INVISIBLE);
        Txtganador.setVisibility(View.INVISIBLE);

        //resea la carta a mover
        numeroCarta = 2;
        numeroCartaBanca = 2;

        mov=80;
        movBanca=80;


        //llama a que empiece el jugador de nuevo
        arrayCartas();//resetea las cartas de nuevo
        moverCartaJugador(jugador1,carta1You.getX(),  1);//mueve una carta
    }
//---------------

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
        for(int contador=0;contador< clubs.length;contador++){
            clubs[contador]=false;
            gold[contador]=false;
            cups[contador]=false;
            swords[contador]=false;
        }

    }


    private void elegirCarta(String imagen, String barajaSalida, int numero, AtributosJugadores jugador) {
        int baraja = (int) Math.floor(Math.random() * 4 + 1);//dime la baraja
        int random = (int) Math.floor(Math.random() * imgCartasClub.size() - 1 + 1);//saca una carta

        boolean salir = false;


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
                if (jugador.getNombre().equals("You")) {
                    ponerCartaJugador(numero, randomEnvio, barajaEnvio);
                } else {
                    ponerCartaBanca(numero, randomEnvio, barajaEnvio);
                }

            }
        }, 2700);//tras el giro y to do
    }


    private void ponerCartaJugador(int numero, int random, String barajaSalida) {
        //numero es la posicion
        //random es el numero en la arrayy
        switch (numero) {
            case 1:
                if (barajaSalida.equals("cups")) {
                    carta1You.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta1You.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta1You.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta1You.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 2:
                if (barajaSalida.equals("cups")) {
                    carta2You.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta2You.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta2You.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta2You.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 3:
                if (barajaSalida.equals("cups")) {
                    carta3You.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta3You.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta3You.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta3You.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 4:
                if (barajaSalida.equals("cups")) {
                    carta4You.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta4You.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta4You.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta4You.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 5:
                if (barajaSalida.equals("cups")) {
                    carta5You.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta5You.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta5You.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta5You.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 6:
                if (barajaSalida.equals("cups")) {
                    carta6You.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta6You.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta6You.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta6You.setImageResource(imgCartasGold.get(random));
                }
                break;
        }

    }

    private void ponerCartaBanca(int numero, int random, String barajaSalida) {
        //adaptarlo despues para la banca too
        //numero es la posicion
        //random es el numero en la arrayy


        switch (numero) {
            case 1:
                if (barajaSalida.equals("cups")) {
                    carta1Banca.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta1Banca.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta1Banca.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta1Banca.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 2:
                if (barajaSalida.equals("cups")) {
                    carta2Banca.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta2Banca.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta2Banca.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta2Banca.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 3:
                if (barajaSalida.equals("cups")) {
                    carta3Banca.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta3Banca.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta3Banca.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta3Banca.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 4:
                if (barajaSalida.equals("cups")) {
                    carta4Banca.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta4Banca.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta4Banca.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta4Banca.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 5:
                if (barajaSalida.equals("cups")) {
                    carta5Banca.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta5Banca.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta5Banca.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta5Banca.setImageResource(imgCartasGold.get(random));
                }
                break;


            case 6:
                if (barajaSalida.equals("cups")) {
                    carta6Banca.setImageResource(imgCartasCups.get(random));
                } else if (barajaSalida.equals("clubs")) {
                    carta6Banca.setImageResource(imgCartasClub.get(random));
                } else if (barajaSalida.equals("swords")) {
                    carta6Banca.setImageResource(imgCartasSword.get(random));
                } else if (barajaSalida.equals("golds")) {
                    carta6Banca.setImageResource(imgCartasGold.get(random));
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