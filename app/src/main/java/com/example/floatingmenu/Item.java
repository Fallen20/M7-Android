package com.example.floatingmenu;

public class Item {

    private String titulo1;
    private String titulo2;
    private String titulo3;
    private int imagenIcono;
    private int imagenGrande;
    private String desc;


    public Item(String titulo1, String titulo2, String titulo3, int imagenItem, int imagenGrande, String desc) {
        this.titulo1 = titulo1;
        this.titulo2 = titulo2;
        this.titulo3 = titulo3;
        this.imagenIcono = imagenItem;
        this.imagenGrande = imagenGrande;
        this.desc = desc;
    }

    public String getTitulo1() {
        return titulo1;
    }

    public void setTitulo1(String titulo1) {
        this.titulo1 = titulo1;
    }

    public String getTitulo2() {
        return titulo2;
    }

    public void setTitulo2(String titulo2) {
        this.titulo2 = titulo2;
    }

    public String getTitulo3() {
        return titulo3;
    }

    public void setTitulo3(String titulo3) {
        this.titulo3 = titulo3;
    }

    public int getImagenIcono() {
        return imagenIcono;
    }

    public void setImagenIcono(int imagenIcono) {
        this.imagenIcono = imagenIcono;
    }

    public int getImagenGrande() {
        return imagenGrande;
    }

    public void setImagenGrande(int imagenGrande) {
        this.imagenGrande = imagenGrande;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
