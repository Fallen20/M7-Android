package com.example.edt73kotlin

class BodyMass {

        //formulas
        fun FatMass(altura: Int, circunferencia: Int, gender: GENDER?): Double {
            //si puede ser null has de poner name:DATO?
            //aunque le hayas puesto la condicion que no puede serlo, siempre enviara ?
            //por lo que has de cambiar lo que recibe

            return if (gender==GENDER.MALE) {
                val result = (Constant.RelativeHombre - 20 * altura / circunferencia).toDouble()
                Math.round(result * 100.0) / 100.0
            }
            else if(gender==GENDER.FEMALE) {
                val result = (Constant.RelativeMuejer - 20 * altura / circunferencia).toDouble()
                Math.round(result * 100.0) / 100.0
            }
            else{return -1.0;}
        }

        fun WanderVael(altura: Int, gender: GENDER?): Double {
            return if (gender==GENDER.MALE) {
                val result = (altura - 150) * Constant.WanderHombres + 50
                Math.round(result * 100.0) / 100.0
            }
            else if(gender==GENDER.FEMALE){
                val result = (altura - 150) * Constant.WanderMujeres + 50
                Math.round(result * 100.0) / 100.0
            }
            else{return -1.0;}
        }

        fun Lorentz(altura: Int, edad: Int, gender: GENDER?): Double {

            return if (gender==GENDER.MALE) {
                val result =
                    altura - 100 - (altura - 150).toDouble() / 4 + (edad - 20).toDouble() / Constant.LorentzHombres
                Math.round(result * 100.0) / 100.0
            }
            else if(gender==GENDER.FEMALE){
                val result =
                    altura - 100 - (altura - 150).toDouble() / 4 + (edad - 20).toDouble() / Constant.LorentzMujeres
                Math.round(result * 100.0) / 100.0
            }
            else{return -1.0;}
        }

        fun Creff(altura: Int, edad: Int, morphology: MORPHOLOGY?): Double {
            return if (morphology == MORPHOLOGY.SMALL) {
                val result = (altura - 100 + edad / 10).toDouble() * Math.pow(0.9, 2.0)
                Math.round(result * 100.0) / 100.0
            }
            else if (morphology == MORPHOLOGY.MEDIUM) {
                val result = (altura - 100 + edad / 10).toDouble() * 0.9
                Math.round(result * 100.0) / 100.0
            }
            else if(morphology == MORPHOLOGY.BROAD) {
                val result = (altura - 100 + edad / 10).toDouble() * 0.9 * 1.1
                Math.round(result * 100.0) / 100.0
            }
            else{return -1.0;}
        }

}
