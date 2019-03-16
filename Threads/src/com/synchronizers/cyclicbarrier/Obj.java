package com.synchronizers.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Obj extends Thread{
    private int id;
    CyclicBarrier barrier;

    Obj(int id, CyclicBarrier barrier){
        this.id = id;
        this.barrier = barrier;
    }

    @Override
    public void run() {

        try {
            System.out.println(id);
            barrier.await();
            System.out.println("done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
