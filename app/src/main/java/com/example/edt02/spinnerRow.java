package com.example.edt02;

public class spinnerRow {
    private String texto;
    private int imagen;

    public spinnerRow(String texto, int imagen) {
        this.texto = texto;
        this.imagen = imagen;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "spinnerRow{" +
                "texto='" + texto + '\'' +
                ", imagen=" + imagen +
                '}';
    }
}
