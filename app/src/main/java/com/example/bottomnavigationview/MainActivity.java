package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String HOME1 = "Esto es un texto pasado con una constante";
    private static final String HOME2 = "Declarada en el main";

    private BottomNavigationView bottomNav;
    private FrameLayout frame;

    private HomeFragment homeFragment;
    private UserFragment userFragment;
    private SettingsFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav=findViewById(R.id.bottomNav);
        frame=findViewById(R.id.frame);

        homeFragment=new HomeFragment();
        userFragment=new UserFragment();
        settingsFragment=new SettingsFragment();

        setFragment(homeFragment);//el que sale al abrir la app


        //lo ponemos en listener para que pueda cambiar cuando se le apreta
        //por defecto sale el void!
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {//por defecto sale el void!
                //switch para que cuando le apretas a un boton o otro pues cambie
                switch (item.getItemId()){
                    case R.id.nav_home://los del menu
                        bottomNav.setItemBackgroundResource(R.color.normal);
                        setFragment(homeFragment);//asigna este fragmento a la actividad

                        return true;

                    case R.id.nav_profile://los del menu
                        bottomNav.setItemBackgroundResource(R.color.normal);
                        setFragment(userFragment);//asigna este fragmento a la actividad
                        return true;

                    case R.id.nav_settings://los del menu
                        bottomNav.setItemBackgroundResource(R.color.normal);
                        setFragment(settingsFragment);//asigna este fragmento a la actividad
                        return true;

                    default:
                        return false;
                }
            }});



    }

    public void setFragment(Fragment fragment) {//poner fragment lo hace global y asi no hemos de crar uno por cada una
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();//cambia de fragmento
        fragmentTransaction.replace(R.id.frame, fragment);//ahora el frame de la actividad cambia a cual le dices
        //puedes pasarle el private FrameLayout o hacer un R.id porque aunque este global poner 'frame' no lo coge
        fragmentTransaction.commit();//ejecutalo
    }
}