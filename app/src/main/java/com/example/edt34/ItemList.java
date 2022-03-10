package com.example.edt34;

public class ItemList {
    private int imagen;
    private String tituloGrande;
    private String tituloPeque;
    private String lugar1;
    private String lugar2;

    private String distancia;
    private String desnivel;

    private String desnivelIcono;
    private String cocheIcono;
    private String estado;//open o close


    public ItemList(int imagen, String tituloGrande, String tituloPeque, String lugar1, String lugar2, String distancia, String desnivel, String desnivelIcono, String cocheIcono, String estado) {
        this.imagen = imagen;
        this.tituloGrande = tituloGrande;
        this.tituloPeque = tituloPeque;
        this.lugar1 = lugar1;
        this.lugar2 = lugar2;
        this.distancia = distancia;
        this.desnivel = desnivel;
        this.desnivelIcono = desnivelIcono;
        this.cocheIcono = cocheIcono;
        this.estado = estado;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTituloGrande() {
        return tituloGrande;
    }

    public void setTituloGrande(String tituloGrande) {
        this.tituloGrande = tituloGrande;
    }

    public String getTituloPeque() {
        return tituloPeque;
    }

    public void setTituloPeque(String tituloPeque) {
        this.tituloPeque = tituloPeque;
    }

    public String getLugar1() {
        return lugar1;
    }

    public void setLugar1(String lugar1) {
        this.lugar1 = lugar1;
    }

    public String getLugar2() {
        return lugar2;
    }

    public void setLugar2(String lugar2) {
        this.lugar2 = lugar2;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getDesnivel() {
        return desnivel;
    }

    public void setDesnivel(String desnivel) {
        this.desnivel = desnivel;
    }

    public String getDesnivelIcono() {
        return desnivelIcono;
    }

    public void setDesnivelIcono(String desnivelIcono) {
        this.desnivelIcono = desnivelIcono;
    }

    public String getCocheIcono() {
        return cocheIcono;
    }

    public void setCocheIcono(String cocheIcono) {
        this.cocheIcono = cocheIcono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
