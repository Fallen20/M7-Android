package com.example.floatingmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GridView2 extends AppCompatActivity {


    private Integer[] arrayImagenes={R.drawable.catto,R.drawable.ejemplo,R.drawable.mem,R.drawable.catto,R.drawable.ejemplo,R.drawable.mem};
    private String[] arrayTexto={"Catto","Doggo","Mem","Catto","Doggo","Mem"};
    //tienes que poner los elementos aqui porque el custom lo pilla de aqui y si lo añadimos en el onCreate pilla null y peta
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view2);

        gridView =findViewById(R.id.grid2);
/*
        //añadimos imagenes
        arrayImagenes[0]=R.drawable.catto;
        arrayImagenes[1]=R.drawable.ejemplo;
        arrayImagenes[2]=R.drawable.mem;
        arrayImagenes[3]=R.drawable.catto;
        arrayImagenes[4]=R.drawable.ejemplo;
        arrayImagenes[5]=R.drawable.mem;*/

       /* //añadimos texto
        arrayTexto[0]="Catto";
        arrayTexto[1]="Doggo";
        arrayTexto[2]="Mem";
        arrayTexto[3]="Catto";
        arrayTexto[4]="Doggo";
        arrayTexto[5]="Mem";*/

        //custom en vez de ArrayAdapter
        CustomAdapterGrid customAdapterGrid=new CustomAdapterGrid();
        gridView.setAdapter(customAdapterGrid);
        registerForContextMenu(gridView);
    }

    private class CustomAdapterGrid extends BaseAdapter {
        //base adapter para que pille grid tambien
        //de base esto solo acepta list

        @Override
        public int getCount() {
            return arrayImagenes.length;
        }

        @Override
        public Object getItem(int position) {
            return arrayImagenes[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View vista=getLayoutInflater().inflate(R.layout.item_row_grid, null);//pilla el layout que hemos hecho para cada item

            //instanciar los objetos que tiene
            ImageView imagen=vista.findViewById(R.id.gridImg_Img);
            TextView texto=vista.findViewById(R.id.gridImg_Texto);

            //le damos valor nuevo
            texto.setText(arrayTexto[position]);
            imagen.setImageResource(arrayImagenes[position]);


            return vista;
        }
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