package com.kiev.flowers.service;

import com.kiev.flowers.entity.Flowers;

public class ApplicationRunner {
    public static void main(String[] args) {
        FlowerStore flowerStore = new FlowerStore();

        Flowers[] sellFlow = flowerStore.sell(1, 1, 1);
        flowerStore.outArray(sellFlow);
        System.out.println("\n" + flowerStore.getWallet());

        System.out.println("=======================");

        Flowers[] sellSequenceFlow = flowerStore.sellSequence(3, 2, 1);
        flowerStore.outArray(sellSequenceFlow);
        System.out.println("\n" + flowerStore.getWallet());



    }
}
