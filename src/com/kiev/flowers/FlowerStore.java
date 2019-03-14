package com.kiev.flowers;

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
                flowers.add(new Rose());
            } else if (i < roseAmount + chamomileAmount) {
                flowers.add(new Chamomile());
            } else if (i < flowersAmount) {
                flowers.add(new Tulip());
            }
        }

        wallet = roseAmount * Rose.getPRICE() + chamomileAmount * Chamomile.getPRICE() + tulipAmount * Tulip.getPRICE();
        Flowers[] bouquet = flowers.toArray(new Flowers[flowers.size()]);
        return bouquet;
    }

    public Flowers[] sellSequence(int roseAmount, int chamomileAmount, int tulipAmount) {
        flowersAmount = roseAmount + chamomileAmount + tulipAmount;
        wallet = roseAmount * Rose.getPRICE() + chamomileAmount * Chamomile.getPRICE() + tulipAmount * Tulip.getPRICE();

        for (int i = 0; i < flowersAmount / 3 + (flowersAmount % 3 == 0 ? 0 : 1); i++) {
            if (roseAmount > 0) {
                flowers.add(new Rose());
                roseAmount--;
            }
            if (chamomileAmount > 0) {
                flowers.add(new Chamomile());
                chamomileAmount--;
            }
            if (tulipAmount > 0) {
                flowers.add(new Tulip());
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
