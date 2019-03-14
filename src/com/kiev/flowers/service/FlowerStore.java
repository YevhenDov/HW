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

    public Flowers[] sell(int roseAmount, int chamomileAmount, int tulipAmount) {

        List<Rose> roses = new ArrayList<>();
        List<Chamomile> chamomiles = new ArrayList<>();
        List<Tulip> tulips = new ArrayList<>();
        List<Flowers> flowers = new ArrayList<>();

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

        Flowers[] bouquet = flowers.toArray(new Flowers[flowers.size()]);

        wallet = 0;
        countWallet(bouquet);
        return bouquet;
    }


    public Flowers[] sellSequence(int roseAmount, int chamomileAmount, int tulipAmount) {

        List<Rose> roses = new ArrayList<>();
        List<Chamomile> chamomiles = new ArrayList<>();
        List<Tulip> tulips = new ArrayList<>();
        List<Flowers> flowers = new ArrayList<>();

        flowersAmount = roseAmount + chamomileAmount + tulipAmount;

        for (int i = 0; i < (flowersAmount / 3 + (flowersAmount % 3 == 0 ? 0 : 1)) + 1; i++) {
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

        wallet = 0;
        countWallet(bouquet);
        return bouquet;
    }

    public void outArray(Flowers[] bouquet) {
        for (int i = 0; i < bouquet.length; i++)
            System.out.print(bouquet[i].getPrice() + ", ");
    }

    private void countWallet(Flowers[] bouquet) {
        for (int i = 0; i < bouquet.length; i++) {
            wallet += bouquet[i].getPrice();
        }
    }

    public double getWallet() {
        return wallet;
    }
}
