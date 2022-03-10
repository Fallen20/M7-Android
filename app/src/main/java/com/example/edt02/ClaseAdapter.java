package com.example.edt02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ClaseAdapter extends ArrayAdapter<spinnerRow> {
//extend de la clase con los attributos de img y texto


//constructor
    public ClaseAdapter(Context context, ArrayList<spinnerRow> objects) {
        super(context, 0, objects);
        //el 0 es el layout y no es de esta clase
    }


//metodos
    @Override
    public View getView(int position,@Nullable View convertView,@NonNull ViewGroup parent) {
        //parent es el layout donde lo mostramos
        //el view es el layout de cada obj
        return init(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return init(position,convertView,parent);
    }

    //esto se tiene que hacer en el getView y el GetDropDownView
    //Para ahorrar copiar lo mismo, lo ponemos en un metodo y demos que devuelva esto
    public View init (int position,@Nullable View convertView,@NonNull ViewGroup parent){
        if(convertView==null){//sino esta creado, lo creas
            convertView=LayoutInflater.from(getContext())
                    .inflate(R.layout.spinner_objeto,parent,false);
            //spinner_row3 es el estilo (el layout)
            //parent es el layout donde lo muestra
            //el ultimo false es para ver si se muestra. Se pone false porque al principio no debe salir
        }

        //hacemos hook pero de otra vista y las guardamos en su tipo
        ImageView imagenLinkeada= convertView.findViewById(R.id.ingSpinner);
        TextView textoLinkeado=convertView.findViewById(R.id.txtSpinner);
        //esto es el id del layout, no de la clase

        spinnerRow currentItem= getItem(position);//cada linea del spinner, en este caso es de la clase

        if(currentItem!=null){//si en esa posicion hay algo que mostrar
            imagenLinkeada.setImageResource(currentItem.getImagen());
            textoLinkeado.setText(currentItem.getTexto());
        }
        return convertView;
    }
    //init de inicializar
}
