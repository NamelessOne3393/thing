package com.example.myapplication;

import android.content.Context;

import java.io.Serializable;
import java.util.List;

public class Farm implements Serializable {

    private String name;
    private double latitude;
    private double longitude;
    private String description;

    private String imageName;
    private int imageResId;
    private List<Produce> produces;

    // Constructor
    public Farm(String name, String description, double latitude, double longitude, String imageName, List<Produce> produces) {
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageName = imageName;
        this.produces = produces;
    }

    public Farm(String name, String description, double latitude, double longitude, String imageName) {
        this(name, description, latitude, longitude, imageName, null);
    }

    public Farm(String name, double v, double v1) {
        this(name, null, v, v1, "farm_placeholder");
    }


    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public String getImageName() {
        return imageName;
    }

    public int getImageResId(Context context) {
        return context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public List<Produce> getProduces() {
        return produces;
    }

    public void setProduces(List<Produce> produces) {
        this.produces = produces;
    }
}