package com.blocking;

import java.util.concurrent.*;

public class Blocking {
    private static BlockingQueue<String> queue = new PriorityBlockingQueue<>();

    public static void main(String[] args){

        new Thread(() -> {
             System.out.println("Thread-0 is blocking");
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread-0 already work");
        }).start();

        new Thread(() -> {

            System.out.println(queue.add("Add element"));
        }).start();

    }

}
