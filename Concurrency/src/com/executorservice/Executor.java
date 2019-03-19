package com.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {
    private static final int NUMBERS_OF_THREADS = 2;
    private static final int COUNT_OF_ITERATIONS = 10;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(NUMBERS_OF_THREADS);
        for (int i = 0; i < COUNT_OF_ITERATIONS; i++) {
            service.execute(new outValue(i));
        }
        service.shutdown();

    }

    static class outValue implements Runnable {
        private int value;

        public outValue(int value) {
            this.value = value;
        }

        @Override
        public void run() {
            System.out.println("Value is " + value);
        }
    }
}
