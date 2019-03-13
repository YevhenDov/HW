package com.kiev.flowers;

import java.util.*;
import java.util.List;

public class FlowerStore {
    private int flowersAmount;
    private double wallet;

    List<Rose> roses = new ArrayList<>();
    List<Chamomile> chamomiles = new ArrayList<>();
    List<Tulip> tulips = new ArrayList<>();
    List<Flowers> flowers = new ArrayList<>();

    public Flowers[] sell(int roseAmount, int chamomileAmount, int tulipAmount) {
        flowersAmount = roseAmount + chamomileAmount + tulipAmount;

        for (int i = 0; i < flowersAmount; i++) {
            if (i < roseAmount) {
                flowers.add(new Rose(Rose.price));
            } else if (i < roseAmount + chamomileAmount) {
                flowers.add(new Chamomile(Chamomile.price));
            } else if (i < flowersAmount) {
                flowers.add(new Tulip(Tulip.price));
            }
        }

        wallet = roseAmount * Rose.price + chamomileAmount * Chamomile.price + tulipAmount * Tulip.price;
        Flowers[] bouquet = flowers.toArray(new Flowers[flowers.size()]);
        return bouquet;
    }

    public Flowers[] sellSequence(int roseAmount, int chamomileAmount, int tulipAmount) {
        flowersAmount = roseAmount + chamomileAmount + tulipAmount;
        wallet = roseAmount * Rose.price + chamomileAmount * Chamomile.price + tulipAmount * Tulip.price;

        for (int i = 0; i < flowersAmount; i++) {
            if (roseAmount > 0) {
                flowers.add(new Rose(Rose.price));
                roseAmount--;
            }
            if (chamomileAmount > 0) {
                flowers.add(new Chamomile(Chamomile.price));
                chamomileAmount--;
            }
            if (tulipAmount > 0) {
                flowers.add(new Tulip(Tulip.price));
                tulipAmount--;
            }
        }

        Flowers[] bouquet = flowers.toArray(new Flowers[flowers.size()]);
        return bouquet;
    }

    public void outArray(Flowers[] bouquet) {
        for (int i = 0; i < bouquet.length; i++)
            System.out.print(bouquet[i].getPrice() + ", ");
    }

    public double getWallet() {
        return wallet;
    }
}
