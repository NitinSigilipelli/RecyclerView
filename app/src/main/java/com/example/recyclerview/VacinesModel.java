package com.example.recyclerview;

public class VacinesModel {
    private String title;
    private int image;

    public VacinesModel(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}
