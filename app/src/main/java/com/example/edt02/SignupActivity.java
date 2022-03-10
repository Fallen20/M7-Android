package com.example.edt02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class SignupActivity extends AppCompatActivity {
    DatePickerDialog picker;//esto se necesita para el calendario

    private ArrayList<spinnerRow> objetosClaseSpinner;//esto es para el menu desplegable
    private ClaseAdapter claseAdapter;

    ObjectAnimator scaleLinear;
    ObjectAnimator scaleLinear2;
    ObjectAnimator alphaLinear;
    ObjectAnimator agrandarXTxt;
    ObjectAnimator agrandarYTxt;

    private EditText fecha;
    private Spinner spinner;
    private LinearLayout linear;
    private SwitchCompat switchCompat;
    private TextView retorno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fecha=findViewById(R.id.fecha);
        spinner=findViewById(R.id.spinner);
        linear=findViewById(R.id.linearNewUser);
        switchCompat=findViewById(R.id.switch2);
        retorno=findViewById(R.id.textoVuelta);


        //animaciones del principio
        scaleLinear= ObjectAnimator.ofFloat(linear,"scaleX",0f, 1f);
        scaleLinear2=ObjectAnimator.ofFloat(linear,"scaleY",0f,  1f);//sino se pone en otra posicion
        alphaLinear=ObjectAnimator.ofFloat(linear,"alpha",0f,  1f);

        scaleLinear.setStartDelay(800);
        scaleLinear2.setStartDelay(800);
        alphaLinear.setStartDelay(800);

        scaleLinear.setDuration(800);
        scaleLinear2.setDuration(800);
        alphaLinear.setDuration(800);

        AnimatorSet set=new AnimatorSet();
        set.playTogether(scaleLinear, scaleLinear2,alphaLinear);
        set.start();






        Calendar calendar= Calendar.getInstance();//se instancia el calendario
        int dia=calendar.get(Calendar.DAY_OF_MONTH);
        int month=calendar.get(Calendar.MONTH);
        int year=calendar.get(Calendar.YEAR);

        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                picker=new DatePickerDialog(
                        SignupActivity.this, //el sitio donde estas
                        android.R.style.Theme_Holo_Light_Dialog,//ahora tiene un estilo
                        new DatePickerDialog.OnDateSetListener() {//la clase
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                //esto es lo que escribe
                                fecha.setText(day+"/"+month+"/"+year);//esto es lo que se escribe en sitio del texto

                            }
                        },dia, month, year//ahora los datos que vas a usar: año>mes>dia
                );
                picker.show();
            }
        });



        initList();//ahora tenemos la arraylist llena
        claseAdapter=new ClaseAdapter(this,objetosClaseSpinner);//a la clase que adapta, le damos el contexto (donde queremos que se cree) y la array
        spinner.setAdapter(claseAdapter);//ahora el spinner saca esto

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //el ? en el AdapterView<?> es un general. Le podemos pasar cualquier cosa

                spinnerRow seleccionado = (spinnerRow) parent.getItemAtPosition(position);
                String selectedTxt=seleccionado.getTexto();
                int selectedImg=seleccionado.getImagen();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //Toast.makeText(MainActivity.this, "No has seleccionado nada" , Toast.LENGTH_SHORT).show();
            }
        });


        retorno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                agrandarXTxt=ObjectAnimator.ofFloat(view,"scaleX",0.6f, 1f);
                agrandarYTxt=ObjectAnimator.ofFloat(view,"scaleY",0.6f,  1f);//sino se pone en otra posicion

                agrandarXTxt.setStartDelay(100);
                agrandarYTxt.setStartDelay(100);


                AnimatorSet set=new AnimatorSet();
                set.playTogether(agrandarXTxt, agrandarYTxt);
                set.start();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent=new Intent(SignupActivity.this, DashboardActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 1000);//esto es para ponerle un delay tras apretar



                ///passWord.startAnimation(scaleDown);//manera 2 con xml

            }
        });



    }

    private void initList(){//ahora añadimos cosas a la arraylist
        objetosClaseSpinner=new ArrayList<>();
        objetosClaseSpinner.add(new spinnerRow("Mountain Bike",R.drawable.bike01_png));//
        objetosClaseSpinner.add(new spinnerRow("Cycling Bike",R.drawable.bike02_png));//
        objetosClaseSpinner.add(new spinnerRow("Electric Bike",R.drawable.bike06_png));//
        objetosClaseSpinner.add(new spinnerRow("Road Bike",R.drawable.bike08_png));
        objetosClaseSpinner.add(new spinnerRow("Folding Bike",R.drawable.bike03_png));//
        objetosClaseSpinner.add(new spinnerRow("Hybrid Bike",R.drawable.bike04_png));//
        objetosClaseSpinner.add(new spinnerRow("Touring Bike",R.drawable.bike06_png));//
       //esto podemos hacerlo dentro como el add del menu
    }
}