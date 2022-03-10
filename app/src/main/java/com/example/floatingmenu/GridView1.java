package com.example.floatingmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridView1 extends AppCompatActivity {

    private GridView gridView;

    List<String> arrayGrid=new ArrayList<>();
    ArrayAdapter<String> dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view1);

        gridView=findViewById(R.id.gridview1);

        arrayGrid.add("Opcion 1");
        arrayGrid.add("Opcion 2");
        arrayGrid.add("Opcion 3");
        arrayGrid.add("Opcion 4");
        arrayGrid.add("Opcion 5");
        arrayGrid.add("Opcion 6");
        arrayGrid.add("Opcion 7");
        arrayGrid.add("Opcion 8");

        dataAdapter=new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                arrayGrid
        );//adaptamos la array
        gridView.setAdapter(dataAdapter);//se la damos al grid

        registerForContextMenu(gridView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //hacer el menu por codigo
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Menu grid con titulo");
        menu.add(0,1,1,"Borrar");//grupo, id, posición, el texto que sale
        menu.add(0,2,2,"Compartir");
        menu.add(0,3,3,"Web");
        //el id ha de ser un numero
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();//pillamos lo que apretamos
        switch(item.getItemId()){
            case 1:
                Toast.makeText(this, "Borrando NADA", Toast.LENGTH_SHORT).show();
                return true;

            case 2:
                Toast.makeText(this, "Compartir", Toast.LENGTH_SHORT).show();
                return true;

            case 3:
                Toast.makeText(this, "Web", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onContextItemSelected(item);

        }

    }


}