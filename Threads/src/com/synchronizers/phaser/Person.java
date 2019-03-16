package com.synchronizers.phaser;

import java.util.concurrent.Phaser;

public class Person extends Thread{
    int in;
    int out;
    private Phaser phaser;

    public Person(int in, int out, Phaser phaser){
        this.in = in;
        this.out = out;
        this.phaser = phaser;
        System.out.println(this);
    }

    @Override
    public void run() {
        while (phaser.getPhase() < out){
            phaser.arriveAndAwaitAdvance();
        }
        try {
            Thread.sleep(1);
            System.out.println("Person " + in + " is go out");
            phaser.arriveAndDeregister();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return "Person " + in + " -> " + out;
    }
}
