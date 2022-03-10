package com.example.recyclerclass;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<Animals> animalsArrayList=new ArrayList<>();


    public MyAdapter(Context context, List<Animals> animalsArrayList) {
        this.context = context;
        this.animalsArrayList = animalsArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(animalsArrayList.get(position).getUrlImg()).centerCrop().fit().into(holder.imagen);

        holder.type.setText(animalsArrayList.get(position).getAnimalType());
        holder.nickame.setText(animalsArrayList.get(position).getNickname());
        holder.age.setText(String.valueOf(animalsArrayList.get(position).getAge()));
        holder.birth.setText(String.valueOf(animalsArrayList.get(position).getBirthdate()));
        holder.meal.setText(animalsArrayList.get(position).getMealString());

        holder.layout.setOnClickListener(new View.OnClickListener() {//ahora el layout esta en listener
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailActivity.class);

                intent.putExtra("txt1", animalsArrayList.get(holder.getAdapterPosition()).getAnimalType());
                intent.putExtra("txt2", animalsArrayList.get(holder.getAdapterPosition()).getNickname());
                intent.putExtra("txt3", String.valueOf(animalsArrayList.get(holder.getAdapterPosition()).getAge()));
                intent.putExtra("txt4", String.valueOf(animalsArrayList.get(holder.getAdapterPosition()).getBirthdate()));
                intent.putExtra("txt5", animalsArrayList.get(holder.getAdapterPosition()).getMealString());
                intent.putExtra("txt6", animalsArrayList.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("img", animalsArrayList.get(holder.getAdapterPosition()).getUrlImg());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return animalsArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView type;
        private TextView nickame;
        private TextView age;
        private TextView birth;
        private TextView meal;

        private ConstraintLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imagen=itemView.findViewById(R.id.imagenRow);
            type=itemView.findViewById(R.id.txtDer1);
            nickame=itemView.findViewById(R.id.txtDer2);
            age=itemView.findViewById(R.id.txtDer3);
            birth=itemView.findViewById(R.id.txtDer4);
            meal=itemView.findViewById(R.id.txtDer5);

            layout=itemView.findViewById(R.id.constraintRow);
        }
    }
}
