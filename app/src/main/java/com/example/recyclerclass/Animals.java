package com.example.recyclerclass;

public class Animals {
    private String urlImg;
    private String animalType;
    private String nickname;
    private int age;
    private int birthdate;
    private String[] meals;
    private String description;

    public Animals(String urlImg, String name, String nickname, int age, int birthdate, String[] meals, String description) {
        this.urlImg = urlImg;
        this.animalType = name;
        this.nickname = nickname;
        this.age = age;
        this.birthdate = birthdate;
        this.meals = meals;
        this.description = description;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
    }

    public String[] getMeals() {
        return meals;
    }

    public void setMeals(String[] meals) {
        this.meals = meals;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMealString(){
        String texto="";

        for(int contador=0;contador< meals.length;contador++){
            texto+=meals[contador];
            if(contador!=meals.length-1){texto+=",";}
        }
        return texto;
    }
}
