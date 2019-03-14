package com.kiev.flowers.service;

import com.kiev.flowers.entity.Chamomile;
import com.kiev.flowers.entity.Flowers;
import com.kiev.flowers.entity.Rose;
import com.kiev.flowers.entity.Tulip;

import java.util.ArrayList;
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
                flowers.add(new Rose(Rose.PRICE));
            } else if (i < roseAmount + chamomileAmount) {
                flowers.add(new Chamomile(Chamomile.PRICE));
            } else if (i < flowersAmount) {
                flowers.add(new Tulip(Tulip.PRICE));
            }
        }

        wallet = roseAmount * Rose.PRICE + chamomileAmount * Chamomile.PRICE + tulipAmount * Tulip.PRICE;
        Flowers[] bouquet = flowers.toArray(new Flowers[flowers.size()]);
        return bouquet;
    }

    public Flowers[] sellSequence(int roseAmount, int chamomileAmount, int tulipAmount) {
        flowersAmount = roseAmount + chamomileAmount + tulipAmount;
        wallet = roseAmount * Rose.PRICE + chamomileAmount * Chamomile.PRICE + tulipAmount * Tulip.PRICE;

        for (int i = 0; i < flowersAmount; i++) {
            if (roseAmount > 0) {
                flowers.add(new Rose(Rose.PRICE));
                roseAmount--;
            }
            if (chamomileAmount > 0) {
                flowers.add(new Chamomile(Chamomile.PRICE));
                chamomileAmount--;
            }
            if (tulipAmount > 0) {
                flowers.add(new Tulip(Tulip.PRICE));
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
