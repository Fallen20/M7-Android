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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newyorkapi.JsonObjectTopStories.JsonResultTop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdapterTop extends RecyclerView.Adapter<AdapterTop.MyViewHolder>{
    private Context context;
    private List<JsonResultTop> resultJsons=new ArrayList<>();

    public AdapterTop(Context context, List<JsonResultTop> resultJsons) {
        this.context = context;
        this.resultJsons = resultJsons;
    }

    @NonNull
    @Override
    public AdapterTop.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recycler_row_top,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTop.MyViewHolder holder, int position) {
        holder.tit.setText(resultJsons.get(position).getTitle());
        holder.abs.setText(resultJsons.get(position).getMyabstract());


        //dar el link
        holder.web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri=Uri.parse(resultJsons.get(holder.getAdapterPosition()).getUrl());
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context.getApplicationContext(), DetailActivityTop.class);
                    //enviar cosas
                //comprobar si uno a uno es nulo porque puede ser
                //enviar las cosas poco a poco que enviar un serializable no funciona


                if(resultJsons.get(holder.getAdapterPosition()).getSection()!=null){
                    intent.putExtra("section",resultJsons.get(holder.getAdapterPosition()).getSection());
                }

                if(resultJsons.get(holder.getAdapterPosition()).getSubsection()!=null){
                    intent.putExtra("subsection", resultJsons.get(holder.getAdapterPosition()).getSubsection());
                }

                if(resultJsons.get(holder.getAdapterPosition()).getSection()!=null){
                    intent.putExtra("section",resultJsons.get(holder.getAdapterPosition()).getSection());
                }

                if(resultJsons.get(holder.getAdapterPosition()).getUrl()!=null){
                    intent.putExtra("web", resultJsons.get(holder.getAdapterPosition()).getUrl());//ok
                }

                if(resultJsons.get(holder.getAdapterPosition()).getMultimedia()!=null){
                    if(resultJsons.get(holder.getAdapterPosition()).getMultimedia().get(0).getCopyright()!=null){
                        intent.putExtra("copyright",resultJsons.get(holder.getAdapterPosition()).getMultimedia().get(0).getCopyright());
                    }

                    if(resultJsons.get(holder.getAdapterPosition()).getMultimedia().get(0).getUrl()!=null){
                        intent.putExtra("urlImagen",resultJsons.get(holder.getAdapterPosition()).getMultimedia().get(0).getUrl());
                    }

                    if(resultJsons.get(holder.getAdapterPosition()).getMultimedia().get(0).getCaption()!=null){
                        intent.putExtra("caption",resultJsons.get(holder.getAdapterPosition()).getMultimedia().get(0).getCaption());
                    }
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

        private TextView tit;
        private TextView abs;
        private Button web;
        private RelativeLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            abs=itemView.findViewById(R.id.abstractTop);
            tit=itemView.findViewById(R.id.tituloTop);
            web=itemView.findViewById(R.id.buttonTop);
            layout=itemView.findViewById(R.id.relatibeBGRowTop);
        }
    }
}
