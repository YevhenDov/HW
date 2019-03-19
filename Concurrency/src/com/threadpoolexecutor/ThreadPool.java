package com.threadpoolexecutor;

import com.executorservice.Executor;

import java.util.concurrent.*;

public class ThreadPool {
    private static final int NUMBER_OF_THREADS = 2;
    private static final int COUNT_OF_ITERATIONS = 5;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        Future<Integer> future = service.submit(new Task(COUNT_OF_ITERATIONS));
        System.out.println(future.get());
    }

    static class Task implements Callable<Integer> {
        private int i;
        private int sum;

        public Task(){

        }

        public Task(int i){
            this.i = i;
        }

        @Override
        public Integer call() {
            for (int j = 0; j < i; j++){
                sum += i;
            }
            return sum;
        }
    }
}
