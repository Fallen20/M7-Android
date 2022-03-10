package com.example.bottomnavigationview;

public class Picture {
    private String urlImage;
    private String text;
    private String description;

    public Picture(String urlImage, String text, String description) {
        this.urlImage = urlImage;
        this.text = text;
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
