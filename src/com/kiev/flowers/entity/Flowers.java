package com.kiev.flowers.entity;

abstract public class Flowers {
    private static double price;

    public Flowers(double price) {
        this.price = price;
    }

    public static double getPrice() {
        return price;
    }
}
