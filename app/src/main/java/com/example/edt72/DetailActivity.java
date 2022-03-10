package com.example.edt72;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView tituloDetail;
    private ImageView imageDetail;
    private TextView positionDetail;

    //personalidad
    private TextView personalityDescDetail;

    //story
    private TextView backstoryDescDetail;

    //apariencia
    private ImageView worldSprite;
    private TextView aparienciaTxt;

    //batalla

    private TextView battleDescDetail;

    private ImageView imagenBatallaGrande;
    private TextView imagenBatallaTxt;

    private TextView power1Title;
    private TextView power1Descrip;

    private TextView power2Title;
    private TextView power2Descrip;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tituloDetail=findViewById(R.id.nombreGrande);
        imageDetail=findViewById(R.id.icono);
        positionDetail=findViewById(R.id.position);

        personalityDescDetail=findViewById(R.id.personalityTxt);

        backstoryDescDetail=findViewById(R.id.backstoryTxt);

        worldSprite=findViewById(R.id.OverworldSprite);
        aparienciaTxt=findViewById(R.id.aparienciaInf);

        battleDescDetail=findViewById(R.id.batallaTxt);
        imagenBatallaTxt=findViewById(R.id.battleSpriteTit);

        imagenBatallaGrande=findViewById(R.id.battleSprite);
        power1Title =findViewById(R.id.Power1Tit);
        power1Descrip =findViewById(R.id.Power1Inf);

        power2Title =findViewById(R.id.Power2Tit);
        power2Descrip =findViewById(R.id.Power2Inf);

        Intent i=getIntent();//recuperas los datos que te ha enviado

        String tituloGrande=i.getStringExtra(MainActivity.TITULO_PROD);//recupera esta var de la main y la guarda
        String positionString=i.getStringExtra(MainActivity.POS_PROD);//recupera esta var de la main y la guarda
        int icono=i.getIntExtra(MainActivity.IMG_PROD, R.drawable.asgore);//sino lo encuentra pon a X

        String personalidad= i.getStringExtra(MainActivity.PERSONALITY_PROD);
        String backstory=i.getStringExtra(MainActivity.STORY_PROD);

        String aparienciaTexto=i.getStringExtra(MainActivity.APPARENCE_PROD);
        int aparienciaImg=i.getIntExtra(MainActivity.APPARENCE_IMG, 0);

        String battleDetail=i.getStringExtra(MainActivity.BATTLE_DES_PROD);
        int batallaSprite=i.getIntExtra(MainActivity.BATTLE_SPRITE, 0);
        String battleImgDetail=i.getStringExtra(MainActivity.BATTLE_SPRITE_TXT);

        String power1Tit=i.getStringExtra(MainActivity.POWER1_TIT);
        String power1Desc=i.getStringExtra(MainActivity.POWER1_DESC);

        String power2Tit=i.getStringExtra(MainActivity.POWER2_TIT);
        String power2Desc=i.getStringExtra(MainActivity.POWER2_DESC);

        tituloDetail.setText(tituloGrande);//ahora le asignas el texto que hemos recuperado
        imageDetail.setImageResource(icono);
        positionDetail.setText(positionString);

        personalityDescDetail.setText(personalidad);
        backstoryDescDetail.setText(backstory);

        worldSprite.setImageResource(aparienciaImg);
        aparienciaTxt.setText(aparienciaTexto);

        battleDescDetail.setText(battleDetail);
        imagenBatallaGrande.setImageResource(batallaSprite);
        imagenBatallaTxt.setText(battleImgDetail);

        power1Title.setText(power1Tit);
        power1Descrip.setText(power1Desc);

        power2Title.setText(power2Tit);
        power2Descrip.setText(power2Desc);

    }
}