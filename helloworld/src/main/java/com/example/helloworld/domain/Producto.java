package com.example.helloworld.domain;

public class Producto {
    private int Id;
    private String Name;
    private double Price;

    public Producto(int Id, String Name, double Price){
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
    }

    public int getId(){
        return Id;
    }

    public String getName(){
        return Name;
    }

    public double getPrice(){
        return Price;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
