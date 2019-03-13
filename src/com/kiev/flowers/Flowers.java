package com.kiev.flowers;

abstract class Flowers {
    private double price;

    public Flowers(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
