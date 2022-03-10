package com.example.edt36;

public class Paises {
    String name;
    String urlBandera;

    public Paises(String name, String urlBandera) {
        this.name = name;
        this.urlBandera = urlBandera;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlBandera() {
        return urlBandera;
    }

    public void setUrlBandera(String urlBandera) {
        this.urlBandera = urlBandera;
    }
}
