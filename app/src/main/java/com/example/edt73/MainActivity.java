package com.example.edt73;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLanguage;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private RadioGroup grupoTop;
    private RadioButton fatRadio;
    private RadioButton vaelRadio;
    private RadioButton lorentzRadio;
    private RadioButton creffRadio;

    private RadioGroup grupoGenero;
    private RadioButton maleRadio;
    private RadioButton femaleRadio;

    private RadioGroup grupo2;
    private RadioButton smallRadio;
    private RadioButton mediumRadio;
    private RadioButton broadRadio;

    private LinearLayout heightV1;
    private TextInputEditText height1Numero;
    private LinearLayout heightV2;
    private TextInputEditText height2Numero;
    private LinearLayout waist;
    private TextInputEditText waistNumero;
    private LinearLayout age;
    private TextInputEditText ageNumero;

    private TextView resultGrande;
    private LinearLayout resultGrandeGraella;

    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grupoTop = findViewById(R.id.eleccionSuperior);
        fatRadio = findViewById(R.id.fatRadio);
        vaelRadio = findViewById(R.id.WanRadio);
        lorentzRadio = findViewById(R.id.LorentzRadio);
        creffRadio = findViewById(R.id.creffRadio);

        grupoGenero = findViewById(R.id.genero);
        maleRadio = findViewById(R.id.maleRadio);
        femaleRadio = findViewById(R.id.femaleRadio);

        grupo2 = findViewById(R.id.radio2);
        smallRadio = findViewById(R.id.smallRadio);
        mediumRadio = findViewById(R.id.mediumRadio);
        broadRadio = findViewById(R.id.broadRadio);

        heightV1 = findViewById(R.id.heightLayoutv1);
        heightV2 = findViewById(R.id.heightLayoutv2);
        waist = findViewById(R.id.waistLayout);
        age = findViewById(R.id.ageLinear);
        resultGrande = findViewById(R.id.resultadoGrande);
        resultGrandeGraella = findViewById(R.id.graella);

        height1Numero = findViewById(R.id.height11Numero);
        height2Numero = findViewById(R.id.height2Numero);
        waistNumero = findViewById(R.id.waistNumero);
        ageNumero = findViewById(R.id.ageNumero);

        maleRadio=findViewById(R.id.maleRadio);
        smallRadio=findViewById(R.id.smallRadio);

        boton = findViewById(R.id.boton);


        heightV1.setVisibility(View.INVISIBLE);
        waist.setVisibility(View.INVISIBLE);
        heightV2.setVisibility(View.INVISIBLE);
        age.setVisibility(View.INVISIBLE);


        grupoTop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int seleccionado = grupoTop.getCheckedRadioButtonId();//esto devuelve el id del boton seleccionad
                RadioButton seleccionTexto = findViewById(seleccionado);


                switch (seleccionado) {
                    case R.id.fatRadio://el id que devuelve es el nombre pero en int
                        heightV1.setVisibility(View.VISIBLE);
                        height1Numero.setClickable(true);
                        height1Numero.setEnabled(true);

                        waist.setVisibility(View.VISIBLE);
                        waistNumero.setClickable(true);
                        waistNumero.setEnabled(true);


                        heightV2.setVisibility(View.INVISIBLE);
                        height2Numero.setClickable(false);
                        height2Numero.setEnabled(false);

                        age.setVisibility(View.INVISIBLE);
                        ageNumero.setClickable(false);
                        ageNumero.setEnabled(false);


                        grupo2.setClickable(false);
                        grupoGenero.setClickable(true);
                        maleRadio.setChecked(true);



                        boton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                String altura = height1Numero.getEditableText().toString().trim();
                                String anchura = waistNumero.getEditableText().toString().trim();

                                if (height1Numero.getEditableText().toString().trim().isEmpty() || waistNumero.getEditableText().toString().trim().isEmpty()) {
                                    //vacio

                                    resultGrande.setText(R.string.falta);
                                    resultGrande.setVisibility(View.VISIBLE);
                                    resultGrandeGraella.setVisibility(View.INVISIBLE);
                                } else if (Integer.parseInt(altura) < 0 || Integer.parseInt(anchura) < 0) {//negativo1
                                    resultGrande.setVisibility(View.VISIBLE);
                                    resultGrande.setText(R.string.negativo);
                                    resultGrandeGraella.setVisibility(View.INVISIBLE);
                                } else {


                                    if (!genero().equals(null)) {
                                        double resultado = BodyMass.FatMass(Integer.parseInt(altura), Integer.parseInt(anchura), genero());
                                        resultGrande.setText(resultado + " %");
                                        resultGrande.setVisibility(View.VISIBLE);
                                        resultGrandeGraella.setVisibility(View.VISIBLE);
                                    }


                                }


                            }

                        });//boton


                        break;

                    case R.id.WanRadio://el id que devuelve es el nombre pero en int
                        grupoGenero.clearCheck();

                        heightV1.setVisibility(View.VISIBLE);
                        height1Numero.setClickable(true);
                        height1Numero.setEnabled(true);


                        waist.setVisibility(View.INVISIBLE);
                        waistNumero.setClickable(false);
                        waistNumero.setEnabled(false);

                        heightV2.setVisibility(View.INVISIBLE);
                        height2Numero.setClickable(false);
                        height2Numero.setEnabled(false);

                        age.setVisibility(View.INVISIBLE);
                        ageNumero.setClickable(false);
                        ageNumero.setEnabled(false);

                        resultGrande.setVisibility(View.INVISIBLE);
                        resultGrandeGraella.setVisibility(View.INVISIBLE);

                        grupo2.setClickable(false);
                        grupoGenero.setClickable(true);
                        maleRadio.setChecked(true);

                        boton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                String altura = height1Numero.getEditableText().toString().trim();

                                if (height1Numero.getEditableText().toString().trim().isEmpty()) {
                                    //vacio

                                    resultGrande.setText(R.string.falta);
                                    resultGrande.setVisibility(View.VISIBLE);
                                    resultGrandeGraella.setVisibility(View.INVISIBLE);
                                } else if (Integer.parseInt(altura) < 0) {//negativo1
                                    resultGrande.setVisibility(View.VISIBLE);
                                    resultGrande.setText(R.string.negativo);
                                    resultGrandeGraella.setVisibility(View.INVISIBLE);
                                } else {


                                    if (!genero().equals(null)) {
                                        double resultado = BodyMass.WanderVael(Integer.parseInt(altura), genero());
                                        resultGrande.setText(resultado + " Kg");
                                        resultGrande.setVisibility(View.VISIBLE);
                                        resultGrandeGraella.setVisibility(View.INVISIBLE);
                                    }

                                }


                            }

                        });//boton


                        break;

                    case R.id.LorentzRadio://el id que devuelve es el nombre pero en int
                        grupoGenero.clearCheck();

                        heightV1.setVisibility(View.VISIBLE);
                        height1Numero.setClickable(true);
                        height1Numero.setEnabled(true);

                        waist.setVisibility(View.INVISIBLE);
                        waistNumero.setClickable(false);
                        waistNumero.setEnabled(false);

                        heightV2.setVisibility(View.INVISIBLE);
                        height2Numero.setClickable(false);
                        height2Numero.setEnabled(false);

                        age.setVisibility(View.VISIBLE);
                        ageNumero.setClickable(true);
                        ageNumero.setEnabled(true);

                        resultGrande.setVisibility(View.INVISIBLE);
                        resultGrandeGraella.setVisibility(View.INVISIBLE);

                        grupo2.setClickable(false);
                        grupoGenero.setClickable(true);
                        maleRadio.setChecked(true);

                        boton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                String altura = height1Numero.getEditableText().toString().trim();
                                String edad = ageNumero.getEditableText().toString().trim();

                                if (height1Numero.getEditableText().toString().trim().isEmpty() || ageNumero.getEditableText().toString().trim().isEmpty()) {
                                    //vacio

                                    resultGrande.setText(R.string.falta);
                                    resultGrande.setVisibility(View.VISIBLE);
                                    resultGrandeGraella.setVisibility(View.INVISIBLE);
                                } else if (Integer.parseInt(altura) < 0 || Integer.parseInt(edad) < 0) {//negativo
                                    resultGrande.setVisibility(View.VISIBLE);
                                    resultGrande.setText(R.string.negativo);
                                    resultGrandeGraella.setVisibility(View.INVISIBLE);
                                } else {


                                    if (!genero().equals(null)) {
                                        double resultado = BodyMass.Lorentz(Integer.parseInt(altura), Integer.parseInt(edad), genero());
                                        resultGrande.setText(resultado + " Kg");
                                        resultGrande.setVisibility(View.VISIBLE);
                                        resultGrandeGraella.setVisibility(View.INVISIBLE);
                                    }

                                }


                            }

                        });//boton

                        break;

                    case R.id.creffRadio:
                        grupoGenero.clearCheck();

                        heightV1.setVisibility(View.INVISIBLE);
                        height1Numero.setClickable(false);
                        height1Numero.setEnabled(false);


                        waist.setVisibility(View.INVISIBLE);
                        waistNumero.setClickable(false);
                        waistNumero.setEnabled(false);


                        heightV2.setVisibility(View.VISIBLE);
                        height2Numero.setClickable(true);
                        height2Numero.setEnabled(true);


                        age.setVisibility(View.VISIBLE);
                        ageNumero.setClickable(true);
                        ageNumero.setEnabled(true);

                        resultGrande.setVisibility(View.INVISIBLE);
                        resultGrandeGraella.setVisibility(View.INVISIBLE);

                        grupoGenero.setClickable(false);
                        grupo2.setClickable(true);

                        smallRadio.setChecked(true);

                        boton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                String altura = height2Numero.getEditableText().toString().trim();
                                String edad = ageNumero.getEditableText().toString().trim();

                                if (height2Numero.getEditableText().toString().trim().isEmpty() || ageNumero.getEditableText().toString().trim().isEmpty()) {
                                    //vacio

                                    resultGrande.setText(R.string.falta);
                                    resultGrande.setVisibility(View.VISIBLE);
                                    resultGrandeGraella.setVisibility(View.INVISIBLE);
                                } else if (Integer.parseInt(altura) < 0 || Integer.parseInt(edad) < 0) {//negativo1
                                    resultGrande.setVisibility(View.VISIBLE);
                                    resultGrande.setText(R.string.negativo);
                                    resultGrandeGraella.setVisibility(View.INVISIBLE);
                                } else {


                                    if (!morphology().equals(null)) {
                                        double resultado = BodyMass.Creff(Integer.parseInt(altura), Integer.parseInt(edad), morphology());
                                        resultGrande.setText(resultado + " kg");
                                        resultGrande.setVisibility(View.VISIBLE);
                                        resultGrandeGraella.setVisibility(View.INVISIBLE);
                                    }


                                }


                            }

                        });//boton


                        break;
                }

            }
        });

    }

    public GENDER genero() {
        int seleccionadoGenero = grupoGenero.getCheckedRadioButtonId();
        switch (seleccionadoGenero) {
            case R.id.maleRadio:
                return GENDER.MALE;

            case R.id.femaleRadio:
                return GENDER.FEMALE;

            default:
                return null;

        }
    }

    public MORPHOLOGY morphology() {
        int seleccionadoG2 = grupo2.getCheckedRadioButtonId();
        switch (seleccionadoG2) {
            case R.id.smallRadio:
                return MORPHOLOGY.SMALL;

            case R.id.mediumRadio:
                return MORPHOLOGY.MEDIUM;

            case R.id.broadRadio:
                return MORPHOLOGY.BROAD;

            default:
                return null;

        }
    }


}