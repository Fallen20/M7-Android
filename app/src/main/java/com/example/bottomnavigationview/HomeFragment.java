package com.example.bottomnavigationview;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String recuperado1;
    private String recuperado2;

    private List<Picture> pictureList = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            recuperado1 = getArguments().getString(ARG_PARAM1);
            recuperado2 = getArguments().getString(ARG_PARAM2);
        }
        initData();//meter datos
        //aqui no se duplica
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        RecyclerView recyclerView=view.findViewById(R.id.recyclerHome);

        MyAdapter myAdapter=new MyAdapter(getContext(), pictureList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3,RecyclerView.VERTICAL,false));


        return view;
    }

    private void initData() {
        for (int contador = 1; contador <= 38; contador++) {
            String url = "";
            String name = "";
            if (contador < 10) {
                url = "https://joanseculi.com/images/img0" + contador + ".jpg";
                name = "Pic0" + contador;
            } else {
                url = "https://joanseculi.com/images/img" + contador + ".jpg";
                name = "Pic" + contador;
            }

            pictureList.add(new Picture(url, name, "Description"));
        }
    }
}