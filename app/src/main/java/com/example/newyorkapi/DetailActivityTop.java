package com.example.newyorkapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newyorkapi.JsonObjectTopStories.MultimediaTop;
import com.squareup.picasso.Picasso;

public class DetailActivityTop extends AppCompatActivity {

    private ImageView imagen;
    private TextView section;
    private TextView subsection;
    private TextView desc;
    private TextView copy;
    public MultimediaTop multimediaTop;
    public Button web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_top);
        imagen=findViewById(R.id.imagenDetailTop);
        section=findViewById(R.id.section);
        subsection=findViewById(R.id.subsection);
        desc=findViewById(R.id.descTop);
        copy=findViewById(R.id.copyright);
        web=findViewById(R.id.button);



        Intent intent=getIntent();
        //Toast.makeText(getApplicationContext(), intent.getStringExtra("section"), Toast.LENGTH_SHORT).show();

        if(intent.getStringExtra("section")!=null){
            section.setText(intent.getStringExtra("section"));
        }
        else{section.setText(R.string.noSection);}


        if(intent.getStringExtra("subsection")!=null){
            subsection.setText(intent.getStringExtra("subsection"));
        }
        else{subsection.setText("");}


        if(intent.getStringExtra("copyright")!=null){
            copy.setText("(C): "+intent.getStringExtra("copyright"));
        }
        else{copy.setText("(C)");}//con string no parece funcionar


        if(intent.getStringExtra("urlImagen")!=null){
            Picasso.get().load(intent.getStringExtra("urlImagen")).fit().centerCrop().into(imagen);
        }
        else{imagen.setImageResource(0);}


        if(intent.getStringExtra("caption")!=null){
            desc.setText(intent.getStringExtra("caption"));
        }
        else{desc.setText(R.string.noDesc);}



        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(intent.getStringExtra("web")!=null && !intent.getStringExtra("web").equals("")){
                    //puede que se envien nulo o como "" y no puede ser ninguna de las dos
                    Uri uri=Uri.parse(intent.getStringExtra("web"));
                    Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "No web provided", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }
}