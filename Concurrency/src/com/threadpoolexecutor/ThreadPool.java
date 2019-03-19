package com.threadpoolexecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;

public class ThreadPool {
    private static final int NUMBER_OF_THREADS = 2;
    private static final int COUNT_OF_ITERATIONS = 5;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        Future<Integer> future = service.submit(new Task(COUNT_OF_ITERATIONS));
        System.out.println(future.get());
    }

    static class Task implements Callable<Integer> {
        private int numberOfIterations;
        private int sum;

        public Task(){

        }

        public Task(int i){
            this.numberOfIterations = i;
        }

        @Override
        public Integer call() {
            for (int j = 0; j < numberOfIterations; j++){
                sum += numberOfIterations;
            }
            return sum;
        }
    }
}
