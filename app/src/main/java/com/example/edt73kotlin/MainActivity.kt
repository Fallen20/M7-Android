package com.example.edt73kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var grupoTop: RadioGroup
    private lateinit var fatRadio: RadioButton
    private lateinit var vaelRadio: RadioButton
    private lateinit var lorentzRadio: RadioButton
    private lateinit var creffRadio: RadioButton

    private lateinit var grupoGenero: RadioGroup
    private lateinit var maleRadio: RadioButton
    private lateinit var femaleRadio: RadioButton

    private lateinit var grupo2: RadioGroup
    private lateinit var smallRadio: RadioButton
    private lateinit var mediumRadio: RadioButton
    private lateinit var broadRadio: RadioButton

    private lateinit var heightV1: LinearLayout
    private lateinit var height1Numero: TextInputEditText
    private lateinit var heightV2: LinearLayout
    private lateinit var height2Numero: TextInputEditText
    private lateinit var waist: LinearLayout
    private lateinit var waistNumero: TextInputEditText
    private lateinit var age: LinearLayout
    private lateinit var ageNumero: TextInputEditText

    private lateinit var resultGrande: TextView
    private lateinit var resultGrandeGraella: LinearLayout
    private lateinit var boton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bodyMass = BodyMass()

        grupoTop = findViewById(R.id.eleccionSuperior)
        fatRadio = findViewById(R.id.fatRadio)
        vaelRadio = findViewById(R.id.WanRadio)
        lorentzRadio = findViewById(R.id.LorentzRadio)
        creffRadio = findViewById(R.id.creffRadio)

        grupoGenero = findViewById(R.id.genero)
        maleRadio = findViewById(R.id.maleRadio)
        femaleRadio = findViewById(R.id.femaleRadio)

        grupo2 = findViewById(R.id.radio2)
        smallRadio = findViewById(R.id.smallRadio)
        mediumRadio = findViewById(R.id.mediumRadio)
        broadRadio = findViewById(R.id.broadRadio)

        heightV1 = findViewById(R.id.heightLayoutv1)
        heightV2 = findViewById(R.id.heightLayoutv2)
        waist = findViewById(R.id.waistLayout)
        age = findViewById(R.id.ageLinear)
        resultGrande = findViewById(R.id.resultadoGrande)
        resultGrandeGraella = findViewById(R.id.graella)

        height1Numero = findViewById(R.id.height11Numero)
        height2Numero = findViewById(R.id.height2Numero)
        waistNumero = findViewById(R.id.waistNumero)
        ageNumero = findViewById(R.id.ageNumero)

        maleRadio = findViewById(R.id.maleRadio)
        smallRadio = findViewById(R.id.smallRadio)

        boton = findViewById(R.id.boton)


        heightV1.visibility = View.INVISIBLE
        waist.visibility = View.INVISIBLE
        heightV2.visibility = View.INVISIBLE
        age.visibility = View.INVISIBLE
        boton.visibility = View.INVISIBLE


        grupoTop.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->

            val radioSeleccionado = grupoTop.checkedRadioButtonId

            when (radioSeleccionado) {
                R.id.fatRadio -> {
                    heightV1.visibility = View.VISIBLE
                    height1Numero.isClickable = true
                    height1Numero.isEnabled = true

                    waist.visibility = View.VISIBLE
                    waistNumero.isClickable = true
                    waistNumero.isEnabled = true


                    heightV2.visibility = View.INVISIBLE
                    height2Numero.isClickable = false
                    height2Numero.isEnabled = false

                    age.visibility = View.INVISIBLE
                    ageNumero.isClickable = false
                    ageNumero.isEnabled = false


                    grupo2.isClickable = false
                    grupoGenero.isClickable = true


                    boton.visibility = View.VISIBLE


                    boton.setOnClickListener {
                        val altura = height1Numero.editableText.toString()
                        val anchura = waistNumero.getEditableText().toString()
                        //numeros

                        if (altura.isEmpty() || anchura.isEmpty()) {
                            //vacio
                            resultGrande.setText(R.string.falta)
                            resultGrande.visibility = View.VISIBLE
                            resultGrandeGraella.visibility = View.INVISIBLE
                        } else if (altura.toInt() < 0 || anchura.toInt() < 0) { //negativo
                            resultGrande.visibility = View.VISIBLE
                            resultGrande.setText(R.string.negativo)
                            resultGrandeGraella.visibility = View.INVISIBLE
                        } else {

                            val resultado =
                                bodyMass.FatMass(altura.toInt(), anchura.toInt(), genero())
                            //NO USAR EL LET
                            //porque siempre recibe null aunque este seleccionado por defecto

                            if(resultado!=-1.0){
                                resultGrande.visibility = View.VISIBLE
                                resultGrande.setText("$resultado %")
                                resultGrandeGraella.visibility = View.VISIBLE
                            }
                            else{
                                resultGrande.visibility = View.VISIBLE
                                resultGrande.setText(R.string.faltaRadio)
                                resultGrandeGraella.visibility = View.INVISIBLE
                            }



                        }

                    }
                }
                R.id.WanRadio -> {
                    grupoGenero.clearCheck()

                    heightV1.visibility = View.VISIBLE
                    height1Numero.isClickable = true
                    height1Numero.isEnabled = true


                    waist.visibility = View.INVISIBLE
                    waistNumero.isClickable = false
                    waistNumero.isEnabled = false

                    heightV2.visibility = View.INVISIBLE
                    height2Numero.isClickable = false
                    height2Numero.isEnabled = false

                    age.visibility = View.INVISIBLE
                    ageNumero.isClickable = false
                    ageNumero.isEnabled = false

                    resultGrande.visibility = View.INVISIBLE
                    resultGrandeGraella.visibility = View.INVISIBLE

                    grupo2.isClickable = false
                    grupoGenero.isClickable = true


                    boton.visibility = View.VISIBLE


                    boton.setOnClickListener {
                        val altura = height1Numero.editableText.toString()
                        //numeros

                        if (altura.isEmpty()) {
                            //vacio
                            resultGrande.setText(R.string.falta)
                            resultGrande.visibility = View.VISIBLE
                            resultGrandeGraella.visibility = View.INVISIBLE
                        } else if (altura.toInt() < 0) { //negativo
                            resultGrande.visibility = View.VISIBLE
                            resultGrande.setText(R.string.negativo)
                            resultGrandeGraella.visibility = View.INVISIBLE
                        } else {

                            val resultado =
                                bodyMass.WanderVael(altura.toInt(), genero())
                            //NO USAR EL LET
                            //porque siempre recibe null aunque este seleccionado por defecto

                            if(resultado!=-1.0){
                                resultGrande.visibility = View.VISIBLE
                                resultGrande.setText("$resultado Kg")
                                resultGrandeGraella.visibility = View.INVISIBLE
                            }
                            else{
                                resultGrande.visibility = View.VISIBLE
                                resultGrande.setText(R.string.faltaRadio)
                                resultGrandeGraella.visibility = View.INVISIBLE
                            }

                        }

                    }

                }
                R.id.LorentzRadio -> {

                    grupoGenero.clearCheck()

                    heightV1.visibility = View.VISIBLE
                    height1Numero.isClickable = true
                    height1Numero.isEnabled = true

                    waist.visibility = View.INVISIBLE
                    waistNumero.isClickable = false
                    waistNumero.isEnabled = false

                    heightV2.visibility = View.INVISIBLE
                    height2Numero.isClickable = false
                    height2Numero.isEnabled = false

                    age.visibility = View.VISIBLE
                    ageNumero.isClickable = true
                    ageNumero.isEnabled = true

                    boton.visibility = View.VISIBLE

                    resultGrande.visibility = View.INVISIBLE
                    resultGrandeGraella.visibility = View.INVISIBLE

                    grupo2.isClickable = false
                    grupoGenero.isClickable = true



                    boton.setOnClickListener {
                        val altura = height1Numero.editableText.toString()
                        val edad = ageNumero.editableText.toString()
                        //numeros

                        if (altura.isEmpty()||edad.isEmpty()) {
                            //vacio
                            resultGrande.setText(R.string.falta)
                            resultGrande.visibility = View.VISIBLE
                            resultGrandeGraella.visibility = View.INVISIBLE
                        } else if (altura.toInt() < 0 || edad.toInt() < 0) { //negativo
                            resultGrande.visibility = View.VISIBLE
                            resultGrande.setText(R.string.negativo)
                            resultGrandeGraella.visibility = View.INVISIBLE
                        } else {

                            val resultado =
                                bodyMass.Lorentz(altura.toInt(),edad.toInt(), genero())
                            //NO USAR EL LET
                            //porque siempre recibe null aunque este seleccionado por defecto

                            if(resultado!=-1.0){
                                resultGrande.visibility = View.VISIBLE
                                resultGrande.setText("$resultado Kg")
                                resultGrandeGraella.visibility = View.INVISIBLE
                            }
                            else{
                                resultGrande.visibility = View.VISIBLE
                                resultGrande.setText(R.string.faltaRadio)
                                resultGrandeGraella.visibility = View.INVISIBLE
                            }


                        }

                    }
                }
                R.id.creffRadio -> {

                    grupoGenero.clearCheck()

                    heightV1.visibility = View.INVISIBLE
                    height1Numero.isClickable = false
                    height1Numero.isEnabled = false


                    waist.visibility = View.INVISIBLE
                    waistNumero.isClickable = false
                    waistNumero.isEnabled = false


                    heightV2.visibility = View.VISIBLE
                    height2Numero.isClickable = true
                    height2Numero.isEnabled = true


                    age.visibility = View.VISIBLE
                    ageNumero.isClickable = true
                    ageNumero.isEnabled = true

                    boton.visibility = View.VISIBLE

                    resultGrande.visibility = View.INVISIBLE
                    resultGrandeGraella.visibility = View.INVISIBLE

                    grupoGenero.isClickable = false
                    grupo2.isClickable = true

                    boton.setOnClickListener {
                        val altura = height2Numero.editableText.toString()
                        val edad = ageNumero.editableText.toString()
                        //numeros

                        if (altura.isEmpty()||edad.isEmpty()) {
                            //vacio
                            resultGrande.setText(R.string.falta)
                            resultGrande.visibility = View.VISIBLE
                            resultGrandeGraella.visibility = View.INVISIBLE
                        } else if (altura.toInt() < 0 || edad.toInt() < 0) { //negativo
                            resultGrande.visibility = View.VISIBLE
                            resultGrande.setText(R.string.negativo)
                            resultGrandeGraella.visibility = View.INVISIBLE
                        } else {

                            val resultado =
                                bodyMass.Creff(altura.toInt(),edad.toInt(), morphology())
                            //NO USAR EL LET
                            //porque siempre recibe null aunque este seleccionado por defecto

                            if(resultado!=-1.0){
                                resultGrande.visibility = View.VISIBLE
                                resultGrande.setText("$resultado Kg")
                                resultGrandeGraella.visibility = View.INVISIBLE
                            }
                            else{
                                resultGrande.visibility = View.VISIBLE
                                resultGrande.setText(R.string.faltaRadio)
                                resultGrandeGraella.visibility = View.INVISIBLE
                            }


                        }

                    }

                }

            }

        })


    }//oncreate

    fun genero(): GENDER? {
        val seleccionadoGenero = grupoGenero.checkedRadioButtonId
        return when (seleccionadoGenero) {
            R.id.maleRadio -> GENDER.MALE
            R.id.femaleRadio-> GENDER.FEMALE
            else -> null
        }
    }

    fun morphology(): MORPHOLOGY? {
        val seleccionadoG2 = grupo2.checkedRadioButtonId
        return when (seleccionadoG2) {
            R.id.smallRadio -> MORPHOLOGY.SMALL
            R.id.mediumRadio -> MORPHOLOGY.MEDIUM
            R.id.broadRadio->MORPHOLOGY.BROAD
            else -> null
        }
    }
}