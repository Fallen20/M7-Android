package com.example.edt72;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static String TITULO_PROD="com.exampl.Edt72_2parte.TITULO_PROD";
    public static String IMG_PROD="com.exampl.Edt72_2parte.IMG_PROD";
    public static String POS_PROD="com.exampl.Edt72_2parte.POS_PROD";

    //personalidad
    public static String PERSONALITY_PROD="com.exampl.Edt72_2parte.PERSONALITY_PROD";

    //apariencia
    public static String APPARENCE_PROD="com.exampl.Edt72_2parte.APPARENCE_PROD";
    public static String APPARENCE_IMG="com.exampl.Edt72_2parte.APPARENCE_IMG";

    //story
    public static String STORY_PROD="com.exampl.Edt72_2parte.STORY_PROD";

    //batttle
    public static String BATTLE_DES_PROD="com.exampl.Edt72_2parte.BATTLE_DES_PROD";
    public static String BATTLE_SPRITE="com.exampl.Edt72_2parte.BATTLE_SPRITE";
    public static String BATTLE_SPRITE_TXT="com.exampl.Edt72_2parte.BATTLE_SPRITE_TXT";



    public static String POWER1_TIT="com.exampl.Edt72_2parte.POWER1_TIT";
    public static String POWER1_DESC="com.exampl.Edt72_2parte.POWER1_DESC";


    public static String POWER2_TIT="com.exampl.Edt72_2parte.POWER2_TIT";
    public static String POWER2_DESC="com.exampl.Edt72_2parte.POWER2_DESC";

    private CardView card1_1;
    private CardView card1_2;
    private CardView card2_1;
    private CardView card2_2;
    private CardView card3_1;
    private CardView card3_2;
    private CardView card4_1;
    private CardView card4_2;
    private CardView card5_1;
    private CardView card5_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card1_1= findViewById(R.id.card1_1);
        card1_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //los datos de las cosas que ha de salir cuando apretas al primero
                String titulo=getString(R.string.asgore);//este texto esta en string
                String position=getString(R.string.bossMonsterPosition);
                int imagenTop= R.drawable.asgore;

                //personalidad
                String personalidad=getString(R.string.asgorePersonality);

                //apariencia
                 String apariencia=getString(R.string.asgoreApparence);
                 int aparienciaImg=R.drawable.asgore_overworld;

                //story
                String historia=getString(R.string.asgoreBackstoryTxt);

                //batalla
                String batallaRes=getString(R.string.batallaDescAsgore);

                String power1=getString(R.string.FirePalabra);
                String power1Desc=getString(R.string.asgoreFireAttackDesc);

                String power2= getString(R.string.color);
                String power2Desc=getString(R.string.asgoreColorAttack);


                int imagenBatalla=R.drawable.asgore_battle;
                String batallaSpriteTxt=getString(R.string.battleSpriteTxt);


                //intent, para saltar de  pantalla
                Intent intent=new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(TITULO_PROD, titulo);//envias cosas, ahora TITULO_PROD tiene este valor
                intent.putExtra(IMG_PROD, imagenTop);//envias cosas, ahora IMG_PROD tiene este valor
                intent.putExtra(POS_PROD, position);

                intent.putExtra(PERSONALITY_PROD,personalidad);

                intent.putExtra(STORY_PROD, historia);

                intent.putExtra(APPARENCE_PROD, apariencia);
                intent.putExtra(APPARENCE_IMG, aparienciaImg);

                intent.putExtra(BATTLE_DES_PROD, batallaRes);
                intent.putExtra(BATTLE_SPRITE, imagenBatalla);
                intent.putExtra(BATTLE_SPRITE_TXT, batallaSpriteTxt);

                intent.putExtra(POWER1_TIT, power1);
                intent.putExtra(POWER1_DESC, power1Desc);

                intent.putExtra(POWER2_TIT, power2);
                intent.putExtra(POWER2_DESC, power2Desc);

                startActivity(intent);

            }
        });

        //----------------------------
        card1_2= findViewById(R.id.card1_2);
        card1_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //los datos de las cosas que ha de salir cuando apretas al primero
                String titulo=getString(R.string.toriel);//este texto esta en string
                String position=getString(R.string.bossMonsterPosition);
                int imagenTop= R.drawable.tori;

                //personalidad
                String personalidad=getString(R.string.torielPersonality);

                //apariencia
                String apariencia=getString(R.string.torielApparence);
                int aparienciaImg=R.drawable.toriel_overworld;

                //story
                String historia=getString(R.string.torielStory);

                //batalla
                String batallaRes=getString(R.string.batallaDescToriel);

                String power1=getString(R.string.FirePalabra);
                String power1Desc=getString(R.string.toriFireAttack);

                String power2= getString(R.string.blank);
                String power2Desc=getString(R.string.blank);


                int imagenBatalla=R.drawable.toriel_battle;
                String batallaSpriteTxt=getString(R.string.battleSpriteTxt);


                //intent, para saltar de  pantalla
                Intent intent=new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(TITULO_PROD, titulo);//envias cosas, ahora TITULO_PROD tiene este valor
                intent.putExtra(IMG_PROD, imagenTop);//envias cosas, ahora IMG_PROD tiene este valor
                intent.putExtra(POS_PROD, position);

                intent.putExtra(PERSONALITY_PROD,personalidad);

                intent.putExtra(STORY_PROD, historia);

                intent.putExtra(APPARENCE_PROD, apariencia);
                intent.putExtra(APPARENCE_IMG, aparienciaImg);

                intent.putExtra(BATTLE_DES_PROD, batallaRes);
                intent.putExtra(BATTLE_SPRITE, imagenBatalla);
                intent.putExtra(BATTLE_SPRITE_TXT, batallaSpriteTxt);

                intent.putExtra(POWER1_TIT, power1);
                intent.putExtra(POWER1_DESC, power1Desc);

                intent.putExtra(POWER2_TIT, power2);
                intent.putExtra(POWER2_DESC, power2Desc);

                startActivity(intent);

            }
        });

        //----------------------------
        card2_1= findViewById(R.id.card2_1);
        card2_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //los datos de las cosas que ha de salir cuando apretas al primero
                String titulo=getString(R.string.alphys);//este texto esta en string
                String position=getString(R.string.royalScientistPalabra);
                int imagenTop= R.drawable.alphys;

                //personalidad
                String personalidad=getString(R.string.alphysPersonality);

                //apariencia
                String apariencia=getString(R.string.alphysApparence);
                int aparienciaImg=R.drawable.alphys_overworld;

                //story
                String historia=getString(R.string.alphysStory);

                //batalla
                String batallaRes=getString(R.string.battleDescAlphys);

                String power1=getString(R.string.constructionPalabra);
                String power1Desc=getString(R.string.constructionAlphys);

                String power2= getString(R.string.experimentationPalabra);
                String power2Desc=getString(R.string.experimentationAlphys);


                int imagenBatalla=R.drawable.alphys_sprites;
                String batallaSpriteTxt=getString(R.string.battleSpriteTxt);


                //intent, para saltar de  pantalla
                Intent intent=new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(TITULO_PROD, titulo);//envias cosas, ahora TITULO_PROD tiene este valor
                intent.putExtra(IMG_PROD, imagenTop);//envias cosas, ahora IMG_PROD tiene este valor
                intent.putExtra(POS_PROD, position);

                intent.putExtra(PERSONALITY_PROD,personalidad);

                intent.putExtra(STORY_PROD, historia);

                intent.putExtra(APPARENCE_PROD, apariencia);
                intent.putExtra(APPARENCE_IMG, aparienciaImg);

                intent.putExtra(BATTLE_DES_PROD, batallaRes);
                intent.putExtra(BATTLE_SPRITE, imagenBatalla);
                intent.putExtra(BATTLE_SPRITE_TXT, batallaSpriteTxt);

                intent.putExtra(POWER1_TIT, power1);
                intent.putExtra(POWER1_DESC, power1Desc);

                intent.putExtra(POWER2_TIT, power2);
                intent.putExtra(POWER2_DESC, power2Desc);

                startActivity(intent);

            }
        });

        //----------------------------
        card2_2= findViewById(R.id.card2_2);
        card2_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //los datos de las cosas que ha de salir cuando apretas al primero
                String titulo=getString(R.string.undyne);//este texto esta en string
                String position=getString(R.string.bossMonsterPosition);
                int imagenTop= R.drawable.undyne;

                //personalidad
                String personalidad=getString(R.string.undynePersonality);

                //apariencia
                String apariencia=getString(R.string.undyneApparence);
                int aparienciaImg=R.drawable.undyne_overworld;

                //story
                String historia=getString(R.string.undyneStory);

                //batalla
                String batallaRes=getString(R.string.undyneBattleDesc);

                String power1=getString(R.string.undyneAttTit1);
                String power1Desc=getString(R.string.undyneDescAtt1);

                String power2= getString(R.string.determinationPalabra);
                String power2Desc=getString(R.string.undyneDeterminationAttack);


                int imagenBatalla=R.drawable.undyne_battle;
                String batallaSpriteTxt=getString(R.string.battleSpriteTxt);


                //intent, para saltar de  pantalla
                Intent intent=new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(TITULO_PROD, titulo);//envias cosas, ahora TITULO_PROD tiene este valor
                intent.putExtra(IMG_PROD, imagenTop);//envias cosas, ahora IMG_PROD tiene este valor
                intent.putExtra(POS_PROD, position);

                intent.putExtra(PERSONALITY_PROD,personalidad);

                intent.putExtra(STORY_PROD, historia);

                intent.putExtra(APPARENCE_PROD, apariencia);
                intent.putExtra(APPARENCE_IMG, aparienciaImg);

                intent.putExtra(BATTLE_DES_PROD, batallaRes);
                intent.putExtra(BATTLE_SPRITE, imagenBatalla);
                intent.putExtra(BATTLE_SPRITE_TXT, batallaSpriteTxt);

                intent.putExtra(POWER1_TIT, power1);
                intent.putExtra(POWER1_DESC, power1Desc);

                intent.putExtra(POWER2_TIT, power2);
                intent.putExtra(POWER2_DESC, power2Desc);

                startActivity(intent);

            }
        });

        //----------------------------
        card3_1= findViewById(R.id.card3_1);
        card3_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //los datos de las cosas que ha de salir cuando apretas al primero
                String titulo=getString(R.string.sans);//este texto esta en string
                String position=getString(R.string.bossMonsterPosition);
                int imagenTop= R.drawable.sans;

                //personalidad
                String personalidad=getString(R.string.sansPersonality);

                //apariencia
                String apariencia=getString(R.string.sansApparence);
                int aparienciaImg=R.drawable.sans_overworld;

                //story
                String historia=getString(R.string.sansHistoria);

                //batalla
                String batallaRes="hola esto es la batalla contra el personaje blablablablabablablablablabablablablablaba";

                String power1=getString(R.string.bonesPalabra);
                String power1Desc=getString(R.string.blank);

                String power2= getString(R.string.color);
                String power2Desc=getString(R.string.blueSoulAttack);


                int imagenBatalla=R.drawable.sans_battle;
                String batallaSpriteTxt=getString(R.string.battleSpriteTxt);


                //intent, para saltar de  pantalla
                Intent intent=new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(TITULO_PROD, titulo);//envias cosas, ahora TITULO_PROD tiene este valor
                intent.putExtra(IMG_PROD, imagenTop);//envias cosas, ahora IMG_PROD tiene este valor
                intent.putExtra(POS_PROD, position);

                intent.putExtra(PERSONALITY_PROD,personalidad);

                intent.putExtra(STORY_PROD, historia);

                intent.putExtra(APPARENCE_PROD, apariencia);
                intent.putExtra(APPARENCE_IMG, aparienciaImg);

                intent.putExtra(BATTLE_DES_PROD, batallaRes);
                intent.putExtra(BATTLE_SPRITE, imagenBatalla);
                intent.putExtra(BATTLE_SPRITE_TXT, batallaSpriteTxt);

                intent.putExtra(POWER1_TIT, power1);
                intent.putExtra(POWER1_DESC, power1Desc);

                intent.putExtra(POWER2_TIT, power2);
                intent.putExtra(POWER2_DESC, power2Desc);

                startActivity(intent);

            }
        });

        //----------------------------
        card3_2= findViewById(R.id.card3_2);
        card3_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //los datos de las cosas que ha de salir cuando apretas al primero
                String titulo=getString(R.string.papyrus);//este texto esta en string
                String position=getString(R.string.bossMonsterPosition);
                int imagenTop= R.drawable.paps;

                //personalidad
                String personalidad=getString(R.string.papyrusPersonality);

                //apariencia
                String apariencia=getString(R.string.papyrusApparence);
                int aparienciaImg=R.drawable.papyrus_overworld;

                //story
                String historia="hola esto es la historia del personaje blablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablaba";

                //batalla
                String batallaRes="hola esto es la batalla contra el personaje blablablablabablablablablabablablablablaba";

                String power1=getString(R.string.color);
                String power1Desc="hecha fuego fiuuu";

                String power2= getString(R.string.color);
                String power2Desc=getString(R.string.blueSoulAttack);


                int imagenBatalla=R.drawable.papyrus_fight;
                String batallaSpriteTxt=getString(R.string.battleSpriteTxt);


                //intent, para saltar de  pantalla
                Intent intent=new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(TITULO_PROD, titulo);//envias cosas, ahora TITULO_PROD tiene este valor
                intent.putExtra(IMG_PROD, imagenTop);//envias cosas, ahora IMG_PROD tiene este valor
                intent.putExtra(POS_PROD, position);

                intent.putExtra(PERSONALITY_PROD,personalidad);

                intent.putExtra(STORY_PROD, historia);

                intent.putExtra(APPARENCE_PROD, apariencia);
                intent.putExtra(APPARENCE_IMG, aparienciaImg);

                intent.putExtra(BATTLE_DES_PROD, batallaRes);
                intent.putExtra(BATTLE_SPRITE, imagenBatalla);
                intent.putExtra(BATTLE_SPRITE_TXT, batallaSpriteTxt);

                intent.putExtra(POWER1_TIT, power1);
                intent.putExtra(POWER1_DESC, power1Desc);

                intent.putExtra(POWER2_TIT, power2);
                intent.putExtra(POWER2_DESC, power2Desc);

                startActivity(intent);

            }
        });

        //----------------------------
        card4_1= findViewById(R.id.card4_1);
        card4_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //los datos de las cosas que ha de salir cuando apretas al primero
                String titulo=getString(R.string.mettaton);//este texto esta en string
                String position=getString(R.string.bossMonsterPosition);
                int imagenTop= R.drawable.mettaton;

                //personalidad
                String personalidad="hola esto es la personalidad del personaje blablablablabablablablablabablablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablaba";

                //apariencia
                String apariencia="hola esto es la apariencia del personaje blablablablabablablablablabablablablablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablaba";
                int aparienciaImg=R.drawable.mettaton_overworld;

                //story
                String historia="hola esto es la historia del personaje blablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablaba";

                //batalla
                String batallaRes="hola esto es la batalla contra el personaje blablablablabablablablablabablablablablaba";

                String power1="Robots";
                String power1Desc="hecha fuego fiuuu";

                String power2= getString(R.string.blank);
                String power2Desc=getString(R.string.blank);


                int imagenBatalla=+R.drawable.mettaton_battle;
                String batallaSpriteTxt=getString(R.string.battleSpriteTxt);


                //intent, para saltar de  pantalla
                Intent intent=new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(TITULO_PROD, titulo);//envias cosas, ahora TITULO_PROD tiene este valor
                intent.putExtra(IMG_PROD, imagenTop);//envias cosas, ahora IMG_PROD tiene este valor
                intent.putExtra(POS_PROD, position);

                intent.putExtra(PERSONALITY_PROD,personalidad);

                intent.putExtra(STORY_PROD, historia);

                intent.putExtra(APPARENCE_PROD, apariencia);
                intent.putExtra(APPARENCE_IMG, aparienciaImg);

                intent.putExtra(BATTLE_DES_PROD, batallaRes);
                intent.putExtra(BATTLE_SPRITE, imagenBatalla);
                intent.putExtra(BATTLE_SPRITE_TXT, batallaSpriteTxt);

                intent.putExtra(POWER1_TIT, power1);
                intent.putExtra(POWER1_DESC, power1Desc);

                intent.putExtra(POWER2_TIT, power2);
                intent.putExtra(POWER2_DESC, power2Desc);

                startActivity(intent);

            }
        });

        //----------------------------
        card4_2= findViewById(R.id.card4_2);
        card4_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //los datos de las cosas que ha de salir cuando apretas al primero
                String titulo=getString(R.string.flowey);//este texto esta en string
                String position=getString(R.string.bossMonsterPosition);
                int imagenTop= R.drawable.flowey;

                //personalidad
                String personalidad="hola esto es la personalidad del personaje blablablablabablablablablabablablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablaba";

                //apariencia
                String apariencia="hola esto es la apariencia del personaje blablablablabablablablablabablablablablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablaba";
                int aparienciaImg=R.drawable.flower_overworld;

                //story
                String historia="hola esto es la historia del personaje blablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablaba";

                //batalla
                String batallaRes="hola esto es la batalla contra el personaje blablablablabablablablablabablablablablaba";

                String power1="Bullets";
                String power1Desc="hecha fuego fiuuu";

                String power2= getString(R.string.blank);
                String power2Desc=getString(R.string.blank);


                int imagenBatalla=R.drawable.flowey_battle;
                String batallaSpriteTxt=getString(R.string.battleSpriteTxt);


                //intent, para saltar de  pantalla
                Intent intent=new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(TITULO_PROD, titulo);//envias cosas, ahora TITULO_PROD tiene este valor
                intent.putExtra(IMG_PROD, imagenTop);//envias cosas, ahora IMG_PROD tiene este valor
                intent.putExtra(POS_PROD, position);

                intent.putExtra(PERSONALITY_PROD,personalidad);

                intent.putExtra(STORY_PROD, historia);

                intent.putExtra(APPARENCE_PROD, apariencia);
                intent.putExtra(APPARENCE_IMG, aparienciaImg);

                intent.putExtra(BATTLE_DES_PROD, batallaRes);
                intent.putExtra(BATTLE_SPRITE, imagenBatalla);
                intent.putExtra(BATTLE_SPRITE_TXT, batallaSpriteTxt);

                intent.putExtra(POWER1_TIT, power1);
                intent.putExtra(POWER1_DESC, power1Desc);

                intent.putExtra(POWER2_TIT, power2);
                intent.putExtra(POWER2_DESC, power2Desc);

                startActivity(intent);

            }
        });

        //----------------------------
        card5_1= findViewById(R.id.card5_1);
        card5_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //los datos de las cosas que ha de salir cuando apretas al primero
                String titulo=getString(R.string.muffet);//este texto esta en string
                String position=getString(R.string.bossMonsterPosition);
                int imagenTop= R.drawable.muffet;

                //personalidad
                String personalidad="hola esto es la personalidad del personaje blablablablabablablablablabablablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablaba";

                //apariencia
                String apariencia="hola esto es la apariencia del personaje blablablablabablablablablabablablablablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablaba";
                int aparienciaImg=R.drawable.muffet_overworld;

                //story
                String historia="hola esto es la historia del personaje blablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablaba";

                //batalla
                String batallaRes="hola esto es la batalla contra el personaje blablablablabablablablablabablablablablaba";

                String power1="Aranas+comida";
                String power1Desc="hecha fuego fiuuu";

                String power2= "Muffin";
                String power2Desc=getString(R.string.blank);


                int imagenBatalla=R.drawable.muffet_battle;
                String batallaSpriteTxt=getString(R.string.battleSpriteTxt);


                //intent, para saltar de  pantalla
                Intent intent=new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(TITULO_PROD, titulo);//envias cosas, ahora TITULO_PROD tiene este valor
                intent.putExtra(IMG_PROD, imagenTop);//envias cosas, ahora IMG_PROD tiene este valor
                intent.putExtra(POS_PROD, position);

                intent.putExtra(PERSONALITY_PROD,personalidad);

                intent.putExtra(STORY_PROD, historia);

                intent.putExtra(APPARENCE_PROD, apariencia);
                intent.putExtra(APPARENCE_IMG, aparienciaImg);

                intent.putExtra(BATTLE_DES_PROD, batallaRes);
                intent.putExtra(BATTLE_SPRITE, imagenBatalla);
                intent.putExtra(BATTLE_SPRITE_TXT, batallaSpriteTxt);

                intent.putExtra(POWER1_TIT, power1);
                intent.putExtra(POWER1_DESC, power1Desc);

                intent.putExtra(POWER2_TIT, power2);
                intent.putExtra(POWER2_DESC, power2Desc);

                startActivity(intent);

            }
        });

        //----------------------------
        card5_2= findViewById(R.id.card5_2);
        card5_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //los datos de las cosas que ha de salir cuando apretas al primero
                String titulo=getString(R.string.onionsan);//este texto esta en string
                String position=getString(R.string.npc);
                int imagenTop= R.drawable.onionsan;

                //personalidad
                String personalidad="hola esto es la personalidad del personaje blablablablabablablablablabablablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablaba";

                //apariencia
                String apariencia="hola esto es la apariencia del personaje blablablablabablablablablabablablablablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablaba";
                int aparienciaImg=R.drawable.onionsan_overworld;

                //story
                String historia="hola esto es la historia del personaje blablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablabablablablablaba";

                //batalla
                String batallaRes="hola esto es la batalla contra el personaje blablablablabablablablablabablablablablaba";

                String power1="Traveling";
                String power1Desc=getString(R.string.blank);

                String power2= getString(R.string.blank);
                String power2Desc=getString(R.string.blank);


                int imagenBatalla=R.drawable.onionsan_sprite;
                String batallaSpriteTxt="As an NPC, he doesn't have a battle. Instead, he has a full room dedicated to talk to him";


                //intent, para saltar de  pantalla
                Intent intent=new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(TITULO_PROD, titulo);//envias cosas, ahora TITULO_PROD tiene este valor
                intent.putExtra(IMG_PROD, imagenTop);//envias cosas, ahora IMG_PROD tiene este valor
                intent.putExtra(POS_PROD, position);

                intent.putExtra(PERSONALITY_PROD,personalidad);

                intent.putExtra(STORY_PROD, historia);

                intent.putExtra(APPARENCE_PROD, apariencia);
                intent.putExtra(APPARENCE_IMG, aparienciaImg);

                intent.putExtra(BATTLE_DES_PROD, batallaRes);
                intent.putExtra(BATTLE_SPRITE, imagenBatalla);
                intent.putExtra(BATTLE_SPRITE_TXT, batallaSpriteTxt);

                intent.putExtra(POWER1_TIT, power1);
                intent.putExtra(POWER1_DESC, power1Desc);

                intent.putExtra(POWER2_TIT, power2);
                intent.putExtra(POWER2_DESC, power2Desc);

                startActivity(intent);

            }
        });
    }
}