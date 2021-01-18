package com.example.AsiaMegaMart.model;

public class SliderModel {

    private String description;
    private int Url;

    public SliderModel(String description, int url) {
        this.description = description;
        Url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUrl() {
        return Url;
    }

    public void setUrl(int url) {
        Url = url;
    }
}
