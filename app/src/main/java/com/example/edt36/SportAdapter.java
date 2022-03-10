package com.example.edt36;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.MyViewHolder>{
    private Context context;
    private List<Sports> sportsList=new ArrayList<>();

    public SportAdapter(Context context, List<Sports> sportsList) {
        this.context = context;
        this.sportsList = sportsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recycler_row_detail,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(sportsList.get(position).getFlagUrl()).fit().centerCrop().into(holder.imagen);
        holder.title.setText(sportsList.get(position).getTextTitle());
        holder.desc.setText(sportsList.get(position).getTextDescription());

        holder.web.setOnClickListener(new View.OnClickListener() {//no funciona
            @Override
            public void onClick(View v) {//para abrir la web en el navegador
                String web="https://"+sportsList.get(holder.getAdapterPosition()).getWeb();

                Uri uri=Uri.parse(web);//parsea el string para que sea un link
                //para que funcione ha de tener https delante
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //se pone Intent.FLAG_ACTIVITY_NEW_TASK o Intent.FLAG_ACTIVITY_CLEAR_TASK
                //porque la iniciamos fuera del contexto de una actividad. Estamos en un adapter
                context.startActivity(intent);
            }
        });

        holder.images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2=new Intent(context, ImageSlideActivity.class);
                intent2.putExtra("imagenes", (Serializable) sportsList.get(holder.getAdapterPosition()).getImagens());
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent2);
            }
        });

        int vacio=0;
        for(String a :sportsList.get(position).getImagens()){
            if(a.equals("null")){vacio++;}
        }
        if(vacio==4){holder.images.setVisibility(View.GONE);}
        else{holder.images.setVisibility(View.VISIBLE);}

    }

    @Override
    public int getItemCount() {
        return sportsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagen;
        private TextView title;
        private TextView desc;
        private Button web;
        private Button images;
        private RelativeLayout relativeLayout;

        public MyViewHolder(@NonNull View itemView) {


            super(itemView);

            imagen=itemView.findViewById(R.id.imageDetail);
            title=itemView.findViewById(R.id.titleDetail);
            desc=itemView.findViewById(R.id.descDetail);
            web=itemView.findViewById(R.id.webDetail);
            images=itemView.findViewById(R.id.imagesDetail);
            relativeLayout=itemView.findViewById(R.id.relativeDetailRow);

        }

    }
}
