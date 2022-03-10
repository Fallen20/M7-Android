package com.example.sevenhalf;

public class AtributosJugadores {
    private String nombre;//para sacar quien gana
    private double puntuacion;
    private boolean hasPlayed;
    private boolean lose;
    private boolean ganar;

    public AtributosJugadores(String nombre, boolean playing, double puntuacion) {
        this.nombre = nombre;
        this.hasPlayed = playing;
        this.puntuacion=puntuacion;
        this.lose=false;
        this.ganar=false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public boolean isHasPlayed() {
        return hasPlayed;
    }

    public void setHasPlayed(boolean hasPlayed) {
        this.hasPlayed = hasPlayed;
    }

    public boolean isLose() {
        return lose;
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }

    public boolean isGanar() {
        return ganar;
    }

    public void setGanar(boolean ganar) {
        this.ganar = ganar;
    }
//METODOD

    //si hace click en el boton de acabar juego
    public void acabarTurno() {
        hasPlayed =false;
    }


    //instant win o lose
    public void comprobarPuntuacion() {
        if(puntuacion>7.5) {lose=true;}//si se pasa de la puntuacion
        else if(puntuacion==7.5) {ganar=true;}
    }
}
