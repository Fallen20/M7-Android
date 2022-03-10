package com.example.edt36;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ImageSlideActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ImageAdapter imageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_slide);
        viewPager=findViewById(R.id.viewPager);


        Intent intent=getIntent();
        ArrayList<String> imagenes= (ArrayList<String>) intent.getSerializableExtra("imagenes");


        imageAdapter=new ImageAdapter(this,imagenes);
        viewPager.setAdapter(imageAdapter);

    }
}