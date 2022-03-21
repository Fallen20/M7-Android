package com.example.examenuf2;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterComentarios extends RecyclerView.Adapter<AdapterComentarios.MyViewHolder>{
    private Context context;
    private List<String> comentarios=new ArrayList<>();

    public AdapterComentarios(Context context, List<String> comentarios) {
        this.context = context;
        this.comentarios = comentarios;
    }

    @NonNull
    @Override
    public AdapterComentarios.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.comentarios_recycler_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterComentarios.MyViewHolder holder, int position) {
        holder.texto.setText(comentarios.get(position));

    }

    @Override
    public int getItemCount() {
        return comentarios.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView texto;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            texto=itemView.findViewById(R.id.textoComentario);
        }
    }
}
