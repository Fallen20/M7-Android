package com.example.bottomnavigationview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String NAME = "param1";
    private static final String DESC = "param2";
    private static final String IMG = "param3";

    // TODO: Rename and change types of parameters
    private String recuperado1;
    private String recuperado2;
    private String recuperado3;//la imagen es un string con el picaso

    public HomeDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeDetailFragment newInstance(String param1, String param2, String param3) {
        HomeDetailFragment fragment = new HomeDetailFragment();
        Bundle args = new Bundle();
        args.putString(NAME, param1);
        args.putString(DESC, param2);
        args.putString(IMG, param3);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            recuperado1 = getArguments().getString(NAME);
            recuperado2 = getArguments().getString(DESC);
            recuperado3 = getArguments().getString(IMG);//imagen
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_detail, container, false);
        ImageView imagen=view.findViewById(R.id.imagenDetail);
        TextView nombre=view.findViewById(R.id.nameDetail);
        TextView desc=view.findViewById(R.id.descriptionDetail);


        if (getArguments() != null) {
            recuperado1 = getArguments().getString(NAME);
            recuperado2 = getArguments().getString(DESC);
            recuperado3 = getArguments().getString(IMG);//imagen

            nombre.setText(recuperado1);
            desc.setText(recuperado2);

            Picasso.get().load(recuperado3).fit().centerCrop().into(imagen);
        }



        return view;
    }
}