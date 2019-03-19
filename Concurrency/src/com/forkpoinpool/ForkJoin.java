package com.forkpoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoin {
    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors();
    private static final long COUNT_OF_OPERATION = 1_000_000_000L;

    public static void main(String[] args){
        ForkJoinPool forkJoinPool = new ForkJoinPool(NUMBER_OF_THREADS);

        System.out.println("Number of threads = " + NUMBER_OF_THREADS);
        System.out.println("start");
        System.out.println(forkJoinPool.invoke(new Task(0, COUNT_OF_OPERATION)));
        System.out.println("finish");

    }

    static class Task extends RecursiveTask<Long> {
        private long from;
        private long to;

        public Task(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if((to - from) <= COUNT_OF_OPERATION / NUMBER_OF_THREADS){
                long result = 0;
                for (long i = from; i < to; i++){
                    result += i;
                }
                return result;
            } else {
                long middle = (to + from) / 2;
                Task firstHalf = new Task(from, middle);
                firstHalf.fork();
                Task secondHalf = new Task(middle + 1, to);
                long secondValue = secondHalf.compute();
                return firstHalf.join() + secondValue;
            }
        }
    }
}
