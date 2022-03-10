package com.example.edt36;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;


    private static String JSONPAISES = "https://www.thesportsdb.com/api/v1/json/2/all_countries.php";
    private ArrayList<Paises> paisesList = new ArrayList<>();
    private SpinnerAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinnerMain);


        initPaisesList();

        spinnerAdapter=new SpinnerAdapter(this, paisesList);
        spinner.setAdapter(spinnerAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Paises seleccionado = (Paises) adapterView.getItemAtPosition(i);
                String selectedTxt=seleccionado.getName();//el nombre del pais

                if(!selectedTxt.equals("Selecciona una opción")){
                    Intent intent=new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("pais",selectedTxt);
                    startActivity(intent);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(), "No hay nada seleccionado", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initPaisesList() {
        Paises pais0=new Paises("Selecciona una opción","a");
        Paises pais1=new Paises("Spain","https://www.banderasphonline.com/wp-content/uploads/2020/03/bandera-espa%C3%B1a-con-escudo-para-exterior-interior.png");
        Paises pais2=new Paises("England","https://www.ecured.cu/images/a/a7/Bandera-de-inglaterra-400x240.png");
        Paises pais3=new Paises("Andorra","https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Flag_of_Andorra.svg/640px-Flag_of_Andorra.svg.png");
        Paises pais4=new Paises("United Arab Emirates","https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Flag_of_the_United_Arab_Emirates.svg/1200px-Flag_of_the_United_Arab_Emirates.svg.png");
        Paises pais5=new Paises("Afghanistan","https://www.banderas-mundo.es/data/flags/w580/af.png");
        Paises pais6=new Paises("Anguilla","https://m.media-amazon.com/images/I/61YIyFStiKL._AC_SX466_.jpg");
        Paises pais7=new Paises("Albania","https://upload.wikimedia.org/wikipedia/commons/3/36/Flag_of_Albania.svg");
        Paises pais8=new Paises("Armenia","https://www.banderas.pro/banderas/s-280-im-bandera-armenia-1.gif");
        Paises pais9=new Paises("Angola","https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Flag_of_Angola.svg/1200px-Flag_of_Angola.svg.png");
        Paises pais10=new Paises("Antarctica","https://media.traveler.es/photos/61375f3e32d932c80fcb8184/master/w_3100,h_2067,c_limit/212316.jpg");
        Paises pais11=new Paises("Argentina","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/800px-Flag_of_Argentina.svg.png");
        Paises pais12=new Paises("Austria","https://www.ecured.cu/images/a/a1/Bandera_Austria.jpg");
        Paises pais13=new Paises("Australia","https://youtooproject.com/wp-content/uploads/2021/02/Bandera_Australia_Viajar.jpg");
        Paises pais14=new Paises("Aruba","https://www.banderasvdk.com/blog/wp-content/uploads/Flag_of_Aruba.svg_.png");
        Paises pais15=new Paises("Barbados","https://upload.wikimedia.org/wikipedia/commons/e/ef/Flag_of_Barbados.svg");
        Paises pais16=new Paises("Belgium","https://cdn.pixabay.com/photo/2015/11/12/15/52/flag-1040530_960_720.png");

        paisesList.add(pais0);
        paisesList.add(pais1);
        paisesList.add(pais2);
        paisesList.add(pais3);
        paisesList.add(pais4);
        paisesList.add(pais5);
        paisesList.add(pais6);
        paisesList.add(pais7);
        paisesList.add(pais8);
        paisesList.add(pais9);
        paisesList.add(pais10);
        paisesList.add(pais11);
        paisesList.add(pais12);
        paisesList.add(pais13);
        paisesList.add(pais14);
        paisesList.add(pais15);
        paisesList.add(pais16);
    }


}