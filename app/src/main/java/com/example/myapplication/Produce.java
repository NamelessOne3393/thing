package com.example.myapplication;

import java.io.Serializable;

public class Produce implements Serializable {
    private String name;
    private Float price;

    public Produce(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Float getPrice() { return price; }
    public void setPrice(Float price) { this.price = price; }
}
