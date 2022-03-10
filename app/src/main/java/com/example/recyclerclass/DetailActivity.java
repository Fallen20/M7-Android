package com.example.recyclerclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView imagen;
    private TextView type;
    private TextView nickname;
    private TextView age;
    private TextView birthdate;
    private TextView meal;
    private TextView description;

    String typeRecuperado,nickRecuperado,ageRecuperado, birthRecuperado,mealRecuperado, descRecuperado;
    String img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imagen=findViewById(R.id.imagenRow);
        type=findViewById(R.id.txtDer1);
        nickname=findViewById(R.id.txtDer2);
        age=findViewById(R.id.txtDer3);
        birthdate=findViewById(R.id.txtDer4);
        meal=findViewById(R.id.txtDer5);
        description=findViewById(R.id.txtDer6);



        Intent intent=getIntent();
        typeRecuperado=intent.getStringExtra("txt1");
        nickRecuperado=intent.getStringExtra("txt2");
        ageRecuperado=intent.getStringExtra("txt3");
        birthRecuperado=intent.getStringExtra("txt4");
        mealRecuperado=intent.getStringExtra("txt5");
        descRecuperado=intent.getStringExtra("txt6");
        img=intent.getStringExtra("img");//lo que recogemos no es la imagen en si, sino el url
//picaso lo pasa a imagen
        Picasso.get().load(img).fit().centerCrop().into(imagen);
        //load la imagen y la mete en

        type.setText(typeRecuperado);
        nickname.setText(nickRecuperado);
        age.setText(ageRecuperado);
        birthdate.setText(birthRecuperado);
        meal.setText(mealRecuperado);
        description.setText(descRecuperado);

    }


}