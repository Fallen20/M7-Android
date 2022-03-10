package com.example.floatingmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Listview1 extends AppCompatActivity {

    private ListView listView;

    List<String> arrayList =new ArrayList<>();
    ArrayAdapter<String> dataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview1);

        listView=findViewById(R.id.listview1);

        arrayList.add("Opcion 1");
        arrayList.add("Opcion 2");
        arrayList.add("Opcion 3");
        arrayList.add("Opcion 4");
        arrayList.add("Opcion 5");
        arrayList.add("Opcion 6");
        arrayList.add("Opcion 7");
        arrayList.add("Opcion 8");

        dataAdapter=new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                arrayList
        );//adaptamos la array
        listView.setAdapter(dataAdapter);//se la damos al grid

        registerForContextMenu(listView);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //hacerlo por recursos
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu1, menu);
        menu.setHeaderTitle("Titulo del menu");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();//pillamos lo que apretamos
        switch(item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Se ha borrado el item seleccionado", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item2:
                Toast.makeText(this, "Has hecho click en compartir", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);

        }

    }
}