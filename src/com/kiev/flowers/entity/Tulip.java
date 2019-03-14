package com.kiev.flowers.entity;

public class Tulip extends Flowers {
    public final static double PRICE = 45;

    public Tulip() {
        super(PRICE);
    }

    public Tulip(double price) {
        super(price);
    }
}
