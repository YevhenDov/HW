package com.kiev.flowers.entity;

public class Rose extends Flowers {
    public final static double PRICE = 100;

    public Rose() {
        super(PRICE);
    }

    public Rose(double price) {
        super(price);
    }
}
