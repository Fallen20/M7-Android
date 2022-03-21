package com.example.examenuf2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterArticles extends RecyclerView.Adapter<AdapterArticles.MyViewHolder>{

    private Context context;
    private List<Article> articleList=new ArrayList<>();

    public AdapterArticles(Context context, List<Article> articleList) {
        this.context = context;
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public AdapterArticles.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.article_recycler_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterArticles.MyViewHolder holder, int position) {
        String trozoDesc=articleList.get(position).getDescription();

        Picasso.get()
                .load(articleList.get(position).getUrlToImage())
                .fit().centerCrop().into(holder.imagen);

        holder.titulo.setText(articleList.get(position).getTitle());
        holder.desc.setText(trozoDesc);
        holder.fecha.setText(articleList.get(position).getPublishedAt());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,DetailActivity.class);
                intent.putExtra("nombre",articleList.get(holder.getAdapterPosition()).title);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView titulo;
        private TextView desc;
        private TextView fecha;
        private RelativeLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imagen=itemView.findViewById(R.id.imagenArticleRow);
            titulo=itemView.findViewById(R.id.tituloArticleRow);
            desc=itemView.findViewById(R.id.descArticleRow);
            fecha=itemView.findViewById(R.id.fechaArticleRow);
            layout=itemView.findViewById(R.id.relativeArticleRow);
        }
    }
}
