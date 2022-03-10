package com.example.bottomnavigationview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private Context context;
    private List<Picture> pictureList=new ArrayList<>();


    public MyAdapter(Context context, List<Picture> pictureList) {
        this.context = context;
        this.pictureList = pictureList;
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
        Picasso.get().load(pictureList.get(position).getUrlImage()).centerCrop().fit().into(holder.imagen);
        holder.texto.setText(pictureList.get(position).getText());

         holder.layout.setOnClickListener(new View.OnClickListener() {//ahora el layout esta en listener
                @Override
                public void onClick(View v) {

                    //cambiar de fragmento
                    HomeDetailFragment homeDetailFragment=HomeDetailFragment.newInstance(
                                pictureList.get(holder.getAdapterPosition()).getText(),
                                pictureList.get(holder.getAdapterPosition()).getDescription(),
                                pictureList.get(holder.getAdapterPosition()).getUrlImage()
                            );
                    //le pasas cosas

                    FragmentManager fragmentManager=((FragmentActivity)context).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();//cambia de fragmento
                    fragmentTransaction.replace(R.id.frame, homeDetailFragment);//ahora el frame de la actividad cambia a cual le dices
                    fragmentTransaction.addToBackStack(null);
                    //puedes pasarle el private FrameLayout o hacer un R.id porque aunque este global poner 'frame' no lo coge
                    fragmentTransaction.commit();//ejecutalo

                }
            });
    }

    @Override
    public int getItemCount() {
        return pictureList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView texto;
        private ConstraintLayout layout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imagen=itemView.findViewById(R.id.itemImage);
            texto=itemView.findViewById(R.id.itemText);
            layout=itemView.findViewById(R.id.constraintItem);
        }
    }
    
}
/*
class Fragmentos extends Fragment{
    public void setFragment(Fragment fragment) {//poner fragment lo hace global y asi no hemos de crar uno por cada una
        MainActivity mainActivity=new MainActivity();

        FragmentManager fragmentManager=context.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();//cambia de fragmento
        fragmentTransaction.replace(R.id.frame, fragment);//ahora el frame de la actividad cambia a cual le dices
        fragmentTransaction.addToBackStack(null);
        //puedes pasarle el private FrameLayout o hacer un R.id porque aunque este global poner 'frame' no lo coge
        fragmentTransaction.commit();//ejecutalo
    }

*/

