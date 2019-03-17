package com.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
    private static int THREADS = 3;
    private static int COUNT_OF_ITERATION = 50_000;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>(THREADS);

        for (int i = 0; i < THREADS; i++) {
            threads.add(new Thread(new Counter()));
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println(atomicInteger.get());
    }

    private static class Counter extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < COUNT_OF_ITERATION; i++) {
                atomicInteger.incrementAndGet();
            }
        }
    }
}
