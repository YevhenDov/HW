package com.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {


    public static void main(String[] args){
        AtomicInteger atomicInteger = new AtomicInteger(0);


        for (int i = 0; i < 20; i++){
            System.out.println(atomicInteger.incrementAndGet());
        }
    }
}
