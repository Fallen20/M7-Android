package com.example.bottomnavigationview;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";//SI AÑADES OTRO, LA CONSTANT HA DE SER STRING
    //se pueden poner muchos
    //estos son los parametros que le pasas pero pueden ser lo que quieras (es como un intent)

    // TODO: Rename and change types of parameters
    private String recuperado1;
    private String recuperado2;
    private int recuperado3;//recupero una imagen
    //SI ENVIAS UNA IMAGEN, ESTO ES INT. SINO STRING


    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    //HAS DE AÑADIR LOS QUE PONGAS AQUI
    public static SettingsFragment newInstance(String param1, String param2, int param3) {//param3 es una imagen en este caso
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);//como es un int (imagen), recoges INT
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            recuperado1 = getArguments().getString(ARG_PARAM1);//se recuperan
            recuperado2 = getArguments().getString(ARG_PARAM2);
            //luego los puedes mostrar
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_settings, container,false);


        return view;
    }
}