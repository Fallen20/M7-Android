package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Picture> pictureList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        for (int i = 1; i <= 38; i++) {
            String finalurl = "";
            String name = "";

            if (i<10) {
                finalurl = "https://joanseculi.com/images/img0" + i + ".jpg";
                name = "img0" + i;
            }
            else {
                finalurl = "https://joanseculi.com/images/img" + i + ".jpg";
                name = "img0" + i;
            }
            pictureList.add(new Picture(finalurl, name, "Description"));
        }
    }
}