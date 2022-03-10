package com.example.floatingmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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

import java.util.ArrayList;

public class Listview3 extends AppCompatActivity {



    ArrayList<Item> items=new ArrayList<>();
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview3);

        listview=findViewById(R.id.list3);


        Item item1=new Item("Catto","This is an image of a cat","It cost 30€",R.drawable.catto,R.drawable.catto2,"Descripcion larga de catto");
        Item item2=new Item("Doggo","This is an image of a dog","It cost 40€",R.drawable.ejemplo,R.drawable.doggo2,"Descripcion larga de ejemplo");
        Item item3=new Item("Cat2","This is an image of a cat","It cost 50€",R.drawable.mem,R.drawable.mem2,"Descripcion larga de mem");
        Item item4=new Item("Catto","This is an image of a cat","It cost 30€",R.drawable.catto,R.drawable.catto2,"Descripcion larga de catto");
        Item item5=new Item("Doggo","This is an image of a dog","It cost 40€",R.drawable.ejemplo,R.drawable.doggo2,"Descripcion larga de ejemplo");
        Item item6=new Item("Cat2","This is an image of a cat","It cost 50€",R.drawable.mem,R.drawable.mem2,"Descripcion larga de mem");

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);

        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),items);
        listview.setAdapter(customAdapter);
        registerForContextMenu(listview);
    }

    private class CustomAdapter extends BaseAdapter {
        private Context context;
        private ArrayList<Item> itemsCustom;
        //como es de una clase hemos de poner esto


        public CustomAdapter(Context context, ArrayList<Item> items) {
            this.context = context;
            this.itemsCustom = items;
        }

        @Override
        public int getCount() {
            return itemsCustom.size();
        }

        @Override
        public Object getItem(int position) {
            return itemsCustom.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View vista=getLayoutInflater().inflate(R.layout.item_row_list,null);

            //aqui solo se ponen los que salen
            ImageView imagen=vista.findViewById(R.id.listImg_Imagen);
            TextView texto1=vista.findViewById(R.id.listImg_Texto1);
            TextView texto2=vista.findViewById(R.id.listImg_Texto2);
            TextView texto3=vista.findViewById(R.id.listImg_Texto3);

            //le damos valor nuevo
            texto1.setText(itemsCustom.get(position).getTitulo1());
            texto2.setText(itemsCustom.get(position).getTitulo2());
            texto3.setText(itemsCustom.get(position).getTitulo3());
            imagen.setImageResource(itemsCustom.get(position).getImagenIcono());


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
        menu.add(0,3,3,"Details");
        //el id ha de ser un numero
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();//pillamos lo que apretamos
        switch(item.getItemId()){
            case 1:
                items.remove(info.position);//borra PERO en la array
                //si no le pones esto de abajo no actualiza la app
                CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),items);
                listview.setAdapter(customAdapter);
                registerForContextMenu(listview);

                Toast.makeText(this, "Borrando", Toast.LENGTH_SHORT).show();
                return true;

            case 2:
                Toast.makeText(this, "compartiendo...", Toast.LENGTH_SHORT).show();
                return true;

            case 3:
                //item.getItemId() es la posicion del floatingMenu
                //info.position es la posicion del objeto en la ARRAY


                Intent intent=new Intent(Listview3.this,DetailsActivity.class);

                //enviar cosas
                intent.putExtra("icono", items.get(info.position).getImagenIcono());
                intent.putExtra("tit1", items.get(info.position).getTitulo1());
                intent.putExtra("tit2", items.get(info.position).getTitulo2());
                intent.putExtra("tit3", items.get(info.position).getTitulo3());
                intent.putExtra("desc", items.get(info.position).getDesc());
                intent.putExtra("imgGrande", items.get(info.position).getImagenGrande());


                startActivity(intent);

                return true;

            default:
                return super.onContextItemSelected(item);

        }

    }
}