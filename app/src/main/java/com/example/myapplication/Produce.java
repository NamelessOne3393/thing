package com.example.myapplication;

import java.io.Serializable;

public class Produce implements Serializable {
    private String name;
    private double price;

    public Produce(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
