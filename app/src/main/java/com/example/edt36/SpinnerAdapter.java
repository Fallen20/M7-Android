package com.example.edt36;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<Paises> {

    public SpinnerAdapter(Context context, ArrayList<Paises> objects) {
        super(context, 0, objects);
    }

    //metodos
    @Override
    public View getView(int position,@Nullable View convertView,@NonNull ViewGroup parent) {
        return init(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return init(position,convertView,parent);
    }

    public View init (int position,@Nullable View convertView,@NonNull ViewGroup parent){
        if(convertView==null){//sino esta creado, lo creas
            convertView=LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.spinner_row,parent,false);
        }

        ImageView imagenLinkeada= convertView.findViewById(R.id.imagenSpinner);
        TextView textoLinkeado=convertView.findViewById(R.id.textoSpinner);

        Paises currentItem= getItem(position);

        if(currentItem!=null){//si en esa posicion hay algo que mostrar
            Picasso.get().load(currentItem.getUrlBandera()).fit().centerCrop().into(imagenLinkeada);
            textoLinkeado.setText(currentItem.getName());
        }
        return convertView;
    }
}

