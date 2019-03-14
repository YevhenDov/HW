package com.kiev.flowers.entity;

public class Chamomile extends Flowers {
    private final static double PRICE = 70;

    public Chamomile() {
        super(PRICE);
    }

    public static double getPRICE() {
        return PRICE;
    }
}
