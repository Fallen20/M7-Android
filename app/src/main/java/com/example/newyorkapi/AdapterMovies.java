package com.example.newyorkapi;

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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import com.example.*;

public class AdapterMovies extends RecyclerView.Adapter<AdapterMovies.MyViewHolder>{
    private Context context;
    private List<ResultJson> resultJsons=new ArrayList<>();

    public AdapterMovies(Context context, List<ResultJson> resultJsons) {
        this.context = context;
        this.resultJsons = resultJsons;
    }

    //PREGUNTAR AL PROFE COMO HACER RESET DEL RECYCLER SI EL RESULTADO NO ES BUENO
    @NonNull
    @Override
    public AdapterMovies.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recycler_row_movies,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMovies.MyViewHolder holder, int position) {


        if(resultJsons.get(position).getMultimedia()!=null){
            Picasso.get().load(resultJsons.get(position).getMultimedia().getSrc()).fit().centerInside().into(holder.imagen);
        }
        else{
            holder.imagen.setImageResource(R.drawable.nytlogo_placeholder);
        }
        //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        holder.titulo.setText(resultJsons.get(position).getDisplay_title());
        holder.subtitulo.setText(resultJsons.get(position).getHeadline());
        holder.desc.setText(resultJsons.get(position).getSummary_short());
        holder.critic.setText(String.valueOf(resultJsons.get(position).getCritics_pick()));
        holder.rating.setText(resultJsons.get(position).getMpaa_rating());

        //dar el link
        holder.web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri=Uri.parse(resultJsons.get(holder.getAdapterPosition()).getLink().getUrl());
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);


//                Toast.makeText(context.getApplicationContext(), resultJsons.get(holder.getAdapterPosition()).getLink().getUrl(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //enviarlo uno a uno porque con serializable no funciona
                Intent intent=new Intent(context.getApplicationContext(), DetailActivityMovie.class);

                intent.putExtra("titulo", resultJsons.get(holder.getAdapterPosition()).getDisplay_title());
                intent.putExtra("headline", resultJsons.get(holder.getAdapterPosition()).getHeadline());
                intent.putExtra("desc", resultJsons.get(holder.getAdapterPosition()).getSummary_short());
                intent.putExtra("pub", resultJsons.get(holder.getAdapterPosition()).getPublication_date());
                intent.putExtra("op", resultJsons.get(holder.getAdapterPosition()).getOpening_date());
                intent.putExtra("up", resultJsons.get(holder.getAdapterPosition()).getDate_updated());
                intent.putExtra("link", resultJsons.get(holder.getAdapterPosition()).getLink().getUrl());
                if(resultJsons.get(holder.getAdapterPosition()).getMultimedia()!=null){
                    intent.putExtra("img", resultJsons.get(holder.getAdapterPosition()).getMultimedia().getSrc());
                }
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultJsons.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagen;
        private TextView titulo;
        private TextView subtitulo;
        private TextView desc;
        private TextView critic;
        private TextView rating;
        private Button web;
        private RelativeLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen=itemView.findViewById(R.id.rowImage);
            titulo=itemView.findViewById(R.id.rowTitulo);
            subtitulo=itemView.findViewById(R.id.rowHeadline);
            desc=itemView.findViewById(R.id.rowDesc);
            critic=itemView.findViewById(R.id.critic);
            rating=itemView.findViewById(R.id.rating);
            web=itemView.findViewById(R.id.botonWeb);
            layout=itemView.findViewById(R.id.relativeBGRow);
        }
    }
}
