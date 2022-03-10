package com.example.edt34;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    //CONSTANTES
    public static String POSITION_PROD="com.exampl.Edt34.POSITION_PROD";





    //OTROS
    List<ItemList> lista=new ArrayList<>();
    ItemList row1=new ItemList(R.drawable.foto1,"Refugi Josep Maria Blanc","Parc Aigüestortes","Vall d'Aran","Catalunya","Distancia: 2:30h","Desnivell: 200m","2.100m","30","Open");
    ItemList row2=new ItemList(R.drawable.foto2,"Refugi Cap de Llauset","Posets-Maladeta","Osca","Aragó","Distancia: 2:15h","Desnivell: 1100m","2.800m","25","Open");
    ItemList row3=new ItemList(R.drawable.foto3,"Refugi Ventosa i Clavell","Parc Aigüestortes","Vall d'Aran","Catalunya","Distancia: 3:15h","Desnivell: 800m","2.150m","45","Close");
    ItemList row4=new ItemList(R.drawable.foto4,"Refugi Amitges","Parc Aigüestortes","Vall d'Aran","Catalunya","Distancia: 2:30h","Desnivell: 750m","2.400m","87","Open");
    ItemList row5=new ItemList(R.drawable.foto5,"Refugi Josep maria Montfort","Alt Pirineu","Vall Ferrera","Catalunya","Distancia: 2:30h","Desnivell: 950m","1.875m","23","Open");

    CustomAdapter customAdapter=new CustomAdapter(this, lista);

    //LAYOUT
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        listView=findViewById(R.id.listView);

        //añadir a la list
        lista.add(row1);
        lista.add(row2);
        lista.add(row3);
        lista.add(row4);
        lista.add(row5);





        //le damos el adapter
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(DashboardActivity.this, ReservaActivity.class);
                ItemList item= (ItemList) adapterView.getItemAtPosition(i);//con esto pillas el pbjeto que estas haciendo click
                //parent es la array
                //los envias
                intent.putExtra(DashboardActivity.POSITION_PROD, i);//le envias la posicion

                startActivity(intent);
            }
        });

    }

    private class CustomAdapter extends BaseAdapter {
        private Context context;//esto siempre
        private List<ItemList> itemModels;//

        public CustomAdapter(Context context, List<ItemList> itemModels) {
            this.context = context;
            this.itemModels = itemModels;
        }

        @Override
        public int getCount() {return itemModels.size();}//el numero de objetos en la lista

        @Override
        public Object getItem(int position) {return itemModels.get(position);}//pilla el obj del item seleccionado

        @Override
        public long getItemId(int position) {return position;}//dame la posicion del item con ese id

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View vista= getLayoutInflater().inflate(R.layout.list_row, null);
            //en el inflate (1a) se pasa el list_row

            //ahora se linkean los elements del layout
            //como findViewById es para vistas, usas la vista del metodo
            TextView tituloGrande=vista.findViewById(R.id.tituloList);
            TextView tituloPeque=vista.findViewById(R.id.tituloPeque);
            TextView lugar1=vista.findViewById(R.id.lugar1);
            TextView lugar2=vista.findViewById(R.id.lugar2);

            TextView distancia=vista.findViewById(R.id.distancia);
            TextView desnivel=vista.findViewById(R.id.desnivel);

            TextView desnivelIcono=vista.findViewById(R.id.desnivelIcono);
            TextView cocheIcono=vista.findViewById(R.id.cocheIcono);
            TextView relojIcono=vista.findViewById(R.id.relojIcono);

            ImageView img=vista.findViewById(R.id.imagenList);




            //de la array, que se refiere a items de arriba.
            tituloGrande.setText(itemModels.get(position).getTituloGrande());
            tituloPeque.setText(itemModels.get(position).getTituloPeque());
            lugar1.setText(itemModels.get(position).getLugar1());
            lugar2.setText(itemModels.get(position).getLugar2());

            distancia.setText(itemModels.get(position).getDistancia());
            desnivel.setText(itemModels.get(position).getDesnivel());

            desnivelIcono.setText(itemModels.get(position).getDesnivelIcono());
            cocheIcono.setText(itemModels.get(position).getCocheIcono());
            relojIcono.setText(itemModels.get(position).getEstado());

            img.setImageResource(itemModels.get(position).getImagen());

            if(relojIcono.getText().equals("Close")){
                relojIcono.setTextColor(Color.RED);
            }

            return vista;///si es null es que lo hace en otro momento
        }
    }
}