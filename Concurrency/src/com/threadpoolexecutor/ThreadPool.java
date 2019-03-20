package com.threadpoolexecutor;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPool {
    private static final int NUMBER_OF_THREADS = 2;
    private static final int VALUE_FOR_MULTIPLY = 5;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        Future<Integer> future = service.submit(new Multiply(VALUE_FOR_MULTIPLY));
        System.out.println(future.get());
    }
}
