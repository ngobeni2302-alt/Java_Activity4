package com.shop.model;

public class Item {
    private String name;
    private double price;

    public Item(String name, double price){
        this.name = name;
        setPrice(price);
    }

    public String getName(){return this.name;}
    public double getPrice(){return this.price;}

    public void setPrice(double price){
        if (price < 0.0){
            price = 0.0;
        }
        this.price = price;
    }

}
