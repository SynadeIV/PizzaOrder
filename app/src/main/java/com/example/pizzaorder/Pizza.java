package com.example.pizzaorder;

public class Pizza {

    public String name;
    public String cheese;
    public String bacon;
    public String crusty;


    public Pizza() {

    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", cheese='" + cheese + '\'' +
                ", bacon='" + bacon + '\'' +
                ", crusty='" + crusty + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public String getBacon() {
        return bacon;
    }

    public void setBacon(String bacon) {
        this.bacon = bacon;
    }

    public String getCrusty() {
        return crusty;
    }

    public void setCrusty(String crusty) {
        this.crusty = crusty;
    }



}
