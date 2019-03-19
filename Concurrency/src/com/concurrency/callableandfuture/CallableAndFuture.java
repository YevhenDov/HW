package com.concurrency.callableandfuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;

public class CallableAndFuture {
    private static final int COUNT_OF_ITERATIONS = 10;
    private static final int NUMBER_OF_THREADS = 5;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        List<Future> allFutures = new ArrayList<>();

        for (int i = 0; i < COUNT_OF_ITERATIONS; i++) {
            Future<Integer> future = service.submit(new Task());
            allFutures.add(future);
        }

        for (int i = 0; i < COUNT_OF_ITERATIONS; i++) {
            Future<Integer> future = allFutures.get(i);
            System.out.println("Future equal: " + future.get());
        }
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(100);
            return new Random().nextInt();
        }
    }
}
