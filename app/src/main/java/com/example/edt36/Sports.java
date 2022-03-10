package com.example.edt36;

import java.util.List;

public class Sports {
    private String flagUrl;
    private String textTitle;
    private String TextDescription;
    private String web;
    private List<String> imagens;

    public Sports() {
    }

    public Sports(String flag, String textTitle, String textDescription, String web, List<String> imagens) {
        this.flagUrl = flag;
        this.textTitle = textTitle;
        TextDescription = textDescription;
        this.web = web;
        this.imagens = imagens;
    }


    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public String getTextDescription() {
        return TextDescription;
    }

    public void setTextDescription(String textDescription) {
        TextDescription = textDescription;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }
}
