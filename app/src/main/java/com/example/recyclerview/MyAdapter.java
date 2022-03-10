package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<Picture> pictureList = new ArrayList();

    public MyAdapter(Context context, List pictureList) {
        this.context = context;
        this.pictureList = pictureList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text.setText(pictureList.get(position).getName());
        Picasso.get().load(pictureList.get(position).getUrl()).centerCrop().fit().into(holder.image);
    }

    @Override
    public int getItemCount() {
        return pictureList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView text;
        private ConstraintLayout constraint;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            text = itemView.findViewById(R.id.textViewId);
            constraint = itemView.findViewById(R.id.layoutId);
        }
    }
}