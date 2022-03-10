package com.example.edt73;

public class BodyMass {


    private GENDER gender;
    private MORPHOLOGY morphology;

    //formulas

    public static double FatMass(int altura, int circunferencia, GENDER gender){
        if(gender.equals(GENDER.MALE)){
            double result=Constant.RelativeHombre-(20*altura)/circunferencia;
            return Math.ceil(result * 100.0) / 100.0;
        }
        else{
            double result=Constant.RelativeMuejer-(20*altura)/circunferencia;
            return Math.ceil(result * 100.0) / 100.0;
        }
    }


    public static double WanderVael(int altura, GENDER gender){
        if(gender.equals(GENDER.MALE)){
            double result=(altura-150)*Constant.WanderHombres+50;
            return Math.round(result * 100.0) / 100.0;
        }
        else{
            double result=(altura-150)*Constant.WanderMujeres+50;
            return Math.round(result * 100.0) / 100.0;
        }
    }

    public static double Lorentz(int altura,int edad, GENDER gender){
        if(gender.equals(GENDER.MALE)){
            double result=altura-100-(double)(altura-150)/4+(double)(edad-20)/Constant.LorentzHombres;

            return Math.round(result * 100.0) / 100.0;
        }
        else{
            double result=altura-100-(double)(altura-150)/4+(double)(edad-20)/Constant.LorentzMujeres;
            return Math.round(result * 100.0) / 100.0;
        }
    }

    public static double Creff(int altura,int edad, MORPHOLOGY morphology){
        if(morphology.equals(MORPHOLOGY.SMALL)){
            double result=(double)(altura-100+edad/10)*Math.pow(0.9,2);
            return Math.round(result * 100.0) / 100.0;
        }
        else if(morphology.equals(MORPHOLOGY.MEDIUM)){
            double result=(double)(altura-100+edad/10)*0.9;
            return Math.round(result * 100.0) / 100.0;
        }
        else{
            double result=(double)(altura-100+edad/10)*0.9*1.1;
            return Math.round(result * 100.0) / 100.0;
        }
    }




}
