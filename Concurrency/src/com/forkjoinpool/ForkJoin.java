package com.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoin {
    public static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors();
    public static final long COUNT_OF_OPERATION = 1_000_000_000L;

    public static void main(String[] args){
        ForkJoinPool forkJoinPool = new ForkJoinPool(NUMBER_OF_THREADS);

        System.out.println("Number of threads = " + NUMBER_OF_THREADS);
        System.out.println("start");
        System.out.println(forkJoinPool.invoke(new Task(0, COUNT_OF_OPERATION)));
        System.out.println("finish");
    }
}
