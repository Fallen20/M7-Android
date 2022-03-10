package com.example.floatingmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button list1;
    private Button list2;
    private Button list3;
    private Button grid1;
    private Button grid2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1=findViewById(R.id.list1);
        list2=findViewById(R.id.list2);
        list3=findViewById(R.id.listBu3);
        grid1=findViewById(R.id.grid1);
        grid2=findViewById(R.id.grid2);

        list1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Listview1.class);
                startActivity(intent);
            }
        });



        grid1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, GridView1.class);
                startActivity(intent);
            }
        });

        list2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Listview2.class);
                startActivity(intent);
            }
        });

        grid2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, GridView2.class);
                startActivity(intent);
            }
        });
        list3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Listview3.class);
                startActivity(intent);
            }
        });



    }
}