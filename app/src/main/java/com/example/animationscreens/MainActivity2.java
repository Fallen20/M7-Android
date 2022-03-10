package com.example.animationscreens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    AnimationDrawable animationDrawable;
    private ImageView imagen;
    private TextView texto;

    public static final int delay=5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //v2
        //instanciamos los frames uno a uno
        //animation=new AnimationDrawable()
        //animation.addFrame(getResoirce.getDrawable(R.drawable.img1), X) //X son los milisegundos
        //una vez> animation.setOneShot(true). infintas, false
        //animation.start()

        texto=findViewById(R.id.textMain2);
        imagen =findViewById(R.id.imagenMain2);

        texto.setScaleX(0f);
        texto.setScaleY(0f);
        texto.setVisibility(View.GONE);


        //SIN ITERAR
        animationDrawable=new AnimationDrawable();
        addFrames();

        animationDrawable.setOneShot(true);// looop
        imagen.setImageDrawable(animationDrawable);
        animationDrawable.start();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                texto.setVisibility(View.VISIBLE);
                texto.animate().scaleX(1f).scaleY(1f).setDuration(1000).start();

                texto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //intent
                        Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
                        startActivity(intent);
                    }
                });

            }
        },delay);


    }

    private void addFrames() {
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket17),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket18),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket19),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket20),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket21),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket22),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket23),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket24),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket25),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket26),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket27),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket28),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket29),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket30),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket31),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket32),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket33),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket34),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket35),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket36),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket37),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket38),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket39),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket40),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket41),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket42),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket43),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket44),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket45),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket46),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket47),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket48),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket49),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket50),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket51),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket52),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket53),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket54),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket55),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket56),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket57),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket58),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket59),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket60),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket61),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket62),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket63),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket64),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket65),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket66),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket67),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket68),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket69),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket70),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket71),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket72),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket73),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket74),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket75),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket76),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket77),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket78),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket79),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket80),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket81),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket82),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket83),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket84),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket85),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket86),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket87),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket88),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket89),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket90),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket91),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket92),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket93),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket94),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket95),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket96),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket97),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket98),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket99),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket100),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket101),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket102),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket103),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket104),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket105),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket106),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket107),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket108),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket109),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket110),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket111),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket112),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket113),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket114),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket115),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket116),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket117),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket118),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket119),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket120),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket121),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket122),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket123),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket124),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket125),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket126),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket127),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket128),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket129),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket130),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket131),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket132),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket133),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket134),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket135),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket136),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket137),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket138),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket139),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket140),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket141),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket142),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket143),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket144),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket145),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket146),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket147),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket148),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket149),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket150),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket151),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket152),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket153),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket154),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket155),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket156),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket157),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket158),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket159),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket160),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket161),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket162),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket163),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket164),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket165),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket166),40);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.rocket167),40);
    }
}