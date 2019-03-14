package com.kiev.flowers.service;

import com.kiev.flowers.entity.Flowers;

public class ApplicationRunner {
    public static void main(String[] args) {
        FlowerStore flowerStore = new FlowerStore();
        FlowerStore flowerStore2 = new FlowerStore();

        Flowers[] sellFlow = flowerStore2.sell(7, 6, 5);
        Flowers[] sellSequenceFlow = flowerStore.sellSequence(7, 6, 5);

        flowerStore.outArray(sellSequenceFlow);
        System.out.println("\n" + flowerStore.getWallet());

        System.out.println("=======================");

        flowerStore2.outArray(sellFlow);
        System.out.println("\n" + flowerStore2.getWallet());
    }
}
