package com.example.edt34;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReservaActivity extends AppCompatActivity {

    Date d = new Date();
    DatePickerDialog picker;//esto se necesita para el calendario

    //CONSTANTE
    private final String EXTRA_EMAIL="com.exampl.Edt34.EXTRA_EMAIL";//a quien
    private final String EXTRA_CC="com.exampl.Edt34.EXTRA_CC";//a quien pero con copia
    private final String EXTRA_SUBJECT="com.exampl.Edt34.EXTRA_SUBJECT";//asunto
    private final String EXTRA_TEXT="com.exampl.Edt34.EXTRA_TEXT";//contenido

    //ARRAYLIST
    List<String> textoSpinner=new ArrayList<>();
    List<Integer> imagenSuperior=new ArrayList<>();


    //LAYOUT
    private ImageView imagen;
    private Spinner spinner;

    private TextInputEditText nombre;
    private TextInputEditText apellido;
    private TextInputEditText email;
    private TextInputEditText numPersonas;

    private Switch pension;
    private RadioGroup radioGroup;
    private RadioButton vegetariano;
    private RadioButton gluten;
    private RadioButton celiaco;
    private RadioButton nada;

    private EditText fechaEntrada;
    private EditText fechaSalida;

    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        //links
        imagen=findViewById(R.id.imagenReserva);
        spinner=findViewById(R.id.spinner);

        //esto es el texto que escribes
        nombre=findViewById(R.id.nombreDentro);
        apellido=findViewById(R.id.apellidoDentro);
        email=findViewById(R.id.emailDentro);
        numPersonas=findViewById(R.id.numPersonasDentro);

        pension=findViewById(R.id.switch1);
        radioGroup=findViewById(R.id.radioGroup);
        vegetariano=findViewById(R.id.radioVegetal);
        gluten=findViewById(R.id.radioGluten);
        celiaco=findViewById(R.id.radioCeliac);
        nada=findViewById(R.id.radioCap);

        fechaEntrada=findViewById(R.id.entradaDate);
        fechaSalida=findViewById(R.id.salidaDate);

        boton=findViewById(R.id.boton);

        //RECUPERAR INTET
        Intent intent=getIntent();
        int posicion=intent.getIntExtra(DashboardActivity.POSITION_PROD,0);


        //ARRAYLISTS
        textoSpinner.add(0,"Refugi Josep Maria Blanc");//el primero
        textoSpinner.add(1,"Refugi Cap de Llauset");
        textoSpinner.add(2,"Refugi Ventosa i Clavell");
        textoSpinner.add(3,"Refugi Amitges");
        textoSpinner.add(4,"Refugi Josep maria Montfort");

        imagenSuperior.add(0,R.drawable.foto1);
        imagenSuperior.add(1,R.drawable.foto2);
        imagenSuperior.add(2,R.drawable.foto3);
        imagenSuperior.add(3,R.drawable.foto4);
        imagenSuperior.add(4,R.drawable.foto5);

        //SPINNERS
        spinner.setSelection(posicion);
        imagen.setImageResource(imagenSuperior.get(posicion));


        ArrayAdapter<String> adapterArrayList=new ArrayAdapter<>(
                this,//a que afecta
                R.layout.support_simple_spinner_dropdown_item,
                textoSpinner//esto busca la array. Como es una propia arraylist y no string-array (que son strings), lo añadimos directamente
        );

        adapterArrayList.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapterArrayList);//le damos todo al spinner

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // String seleccionado = adapterView.getItemAtPosition(i).toString();
                imagen.setImageResource(imagenSuperior.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(ReservaActivity.this, "No has seleccionado nada" , Toast.LENGTH_SHORT).show();

            }
        });

        //SWITCH Y RADIO
//por defecto...
        for(int contador=0;contador<radioGroup.getChildCount();contador++) {
            radioGroup.getChildAt(contador).setClickable(false);//esto es para que no se pueda seleccionar nada
        }
        nada.setChecked(true);

        pension.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {//si esta activado

                    for(int contador=0;contador<radioGroup.getChildCount();contador++) {
                        radioGroup.getChildAt(contador).setClickable(true);//esto es para que no se pueda seleccionar nada
                    }

                }
                else {//si no esta activado
                    for(int contador=0;contador<radioGroup.getChildCount();contador++) {
                        radioGroup.getChildAt(contador).setClickable(false);
                    }
                    //solo este esta seleccionado
                    nada.setChecked(true);//como solo puede estar uno seleccionado no ponemos los demas



                }

            }
        });


        //FECHAS
        //antes de hacer el calendario hemos de hacer las fechas
        Calendar calendar= Calendar.getInstance();//se instancia el calendario
        int dia=calendar.get(Calendar.DAY_OF_MONTH);
        int month=calendar.get(Calendar.MONTH);
        int year=calendar.get(Calendar.YEAR);

        fechaEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                picker=new DatePickerDialog(
                        ReservaActivity.this, //el sitio donde estas
                        //android.R.style.Widget_Holo_ActionBar_Solid,//ahora tiene un estilo
                        new DatePickerDialog.OnDateSetListener() {//la clase
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                //esto es lo que escribe
                                fechaEntrada.setText(day+"/"+(month+1)+"/"+year);//esto es lo que se escribe en sitio del texto

                            }
                        },year, month, dia//ahora los datos que vas a usar: año>mes>dia
                );
                picker.show();
            }
        });


        fechaSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                picker=new DatePickerDialog(
                        ReservaActivity.this, //el sitio donde estas
                        // android.R.style.Theme_Holo_Light,//ahora tiene un estilo
                        new DatePickerDialog.OnDateSetListener() {//la clase
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                //esto es lo que escribe
                                fechaSalida.setText(day+"/"+(month+1)+"/"+year);//esto es lo que se escribe en sitio del texto

                            }
                        },year, month, dia//ahora los datos que vas a usar: año>mes>dia
                );
                picker.show();
            }
        });


        //BOTOON
        //comprobar que el email tiene @
        //comprobar que numPersonas no sea negativo
        //comprobar que ningun campo este vacio

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().trim().contains("@") && !email.getText().toString().trim().isEmpty()){
                    //si no esta vacio, si tiene un @

                    if (!numPersonas.getText().toString().trim().isEmpty() && Integer.parseInt(numPersonas.getText().toString().trim()) > 0) {
                        //si no esta vacio, si no es negativo
                        if (!nombre.getText().toString().trim().isEmpty()){//si no esta vacio

                            if (!apellido.getText().toString().trim().isEmpty()){//si no esta vacio

                                if(radioGroup.getCheckedRadioButtonId()!=-1){//si no hay radio seleccionado

                                    if(!fechaEntrada.getText().toString().trim().equals("Entrada")){//comprobar si se ha metido algo

                                        if(!fechaSalida.getText().toString().trim().equals("Sortida")){//comprobar si se ha metido algo

                                            //mirar si la fecha de salida es mayor a la de entrada
                                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                                            try {
                                                Date entradaDate = sdf.parse(fechaEntrada.getText().toString().trim());
                                                Date salidaDate = sdf.parse(fechaSalida.getText().toString().trim());
                                                
                                                if(entradaDate.after(salidaDate)){Toast.makeText(ReservaActivity.this, "La fecha de salida no puede ser anterior a la de entrada", Toast.LENGTH_SHORT).show();}

                                                if(entradaDate.before(salidaDate)){enviarCorreo();}

                                                if(entradaDate.equals(salidaDate)){Toast.makeText(ReservaActivity.this, "Las fechas no pueden ser iguales", Toast.LENGTH_SHORT).show(); }
                                                
                                            } catch (ParseException e) {Toast.makeText(ReservaActivity.this, "Error en los campos de fecha", Toast.LENGTH_SHORT).show();}


                                        }else{Toast.makeText(ReservaActivity.this, "El campo de fecha de salida no puede estar vacio", Toast.LENGTH_SHORT).show();}

                                    }else{Toast.makeText(ReservaActivity.this, "El campo de fecha de entrada no puede estar vacio", Toast.LENGTH_SHORT).show();}

                                }else{Toast.makeText(ReservaActivity.this, "No se ha seleccionado ningun radio", Toast.LENGTH_SHORT).show();}

                            }else{Toast.makeText(ReservaActivity.this, "El campo apellido no puede estar vacio", Toast.LENGTH_SHORT).show();}

                        }else{Toast.makeText(ReservaActivity.this, "El campo Nombre no puede estar vacio", Toast.LENGTH_SHORT).show();}

                    } else{Toast.makeText(ReservaActivity.this, "El campo NumPersonas es incorrecto", Toast.LENGTH_SHORT).show();}

                } else{Toast.makeText(ReservaActivity.this, "El campo Email es incorrecto", Toast.LENGTH_SHORT).show();}
            }
        });

    }

    public void enviarCorreo(){
        // Toast.makeText(ReservaActivity.this, "Todo correcto!", Toast.LENGTH_SHORT).show();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        String[] TO = {email.getText().toString().trim()};//a quien
        String[] CC = {email.getText().toString().trim()};//a quien pero con copia. Es el email puesto

        String contenido="Nom: "+nombre.getText().toString().trim()+" "+apellido.getText().toString().trim()+"\n"
                +"Refugi: "+spinner.getSelectedItem()+"\n"
                +"Data Entrada: "+fechaEntrada.getText().toString().trim()+"\n"
                +"Data Sortida: "+fechaSalida.getText().toString().trim()+"\n"
                +"Email: "+email.getText().toString().trim()+"\n"
                +"Num. Persones: "+numPersonas.getText().toString().trim()+"\n"
                +"Pensio completa: ";
        if(!pension.isChecked()){contenido+="NO\n";}
        else{contenido+="SI\n";}

        switch (radioGroup.getCheckedRadioButtonId()){
            case R.id.radioVegetal:
                contenido+="Menu: Vegetariá";
                break;
            case R.id.radioGluten:
                contenido+="Menu: Sense gluten";
                break;
            case R.id.radioCeliac:
                contenido+="Menu: Celiac";
                break;
            case R.id.radioCap:
                contenido+="Menu: null";
                break;
        }
        // Toast.makeText(ReservaActivity.this, contenido, Toast.LENGTH_LONG).show();


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Reserva de la app");
        emailIntent.putExtra(Intent.EXTRA_TEXT, contenido);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ReservaActivity.this, "There is no email client installed.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}