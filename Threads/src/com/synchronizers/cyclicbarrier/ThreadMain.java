package com.synchronizers.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class ThreadMain {
    public static final CyclicBarrier BARRIER = new CyclicBarrier(2);

    public static void main(String[] args){
        for (int i = 1; i <= 10; i++){
            new Obj(i, BARRIER).start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
