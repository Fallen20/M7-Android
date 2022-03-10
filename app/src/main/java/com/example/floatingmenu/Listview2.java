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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Listview2 extends AppCompatActivity {

    private Integer[] arrayImagenes2={R.drawable.catto,R.drawable.ejemplo,R.drawable.mem,R.drawable.catto,R.drawable.ejemplo,R.drawable.mem};
    private String[] arrayTexto2={"Catto","Doggo","Mem","Catto","Doggo","Mem"};

    //tienes que poner los elementos aqui porque el custom lo pilla de aqui y si lo añadimos en el onCreate pilla null y peta
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview2);

        listview=findViewById(R.id.list2);

        CustomAdapterList customAdapterList=new CustomAdapterList();
        listview.setAdapter(customAdapterList);
        registerForContextMenu(listview);
    }

    private class CustomAdapterList extends BaseAdapter {
        //base adapter para que pille grid tambien
        //de base esto solo acepta list

        @Override
        public int getCount() {
            return arrayImagenes2.length;
        }

        @Override
        public Object getItem(int position) {
            return arrayImagenes2[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View vista=getLayoutInflater().inflate(R.layout.item_row_list, null);//pilla el layout que hemos hecho para cada item

            //instanciar los objetos que tiene
            ImageView imagen=vista.findViewById(R.id.listImg_Imagen);
            TextView texto=vista.findViewById(R.id.listImg_Texto1);

            //le damos valor nuevo
            texto.setText(arrayTexto2[position]);
            imagen.setImageResource(arrayImagenes2[position]);


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
                Toast.makeText(this, "Borrando", Toast.LENGTH_SHORT).show();
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