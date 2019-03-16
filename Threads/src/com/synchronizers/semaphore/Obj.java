package com.synchronizers.semaphore;

import java.util.concurrent.Semaphore;

public class Obj extends Thread {
    private Semaphore semaphore;

    public Obj(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            System.out.println(getName() + " waiting for a semaphore");
            semaphore.acquire();
            System.out.println(getName() + " do thms 1 second...");
            sleep(1000);
            System.out.println(getName() + " done!");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
