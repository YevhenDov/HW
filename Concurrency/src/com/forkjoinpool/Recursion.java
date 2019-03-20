package com.forkjoinpool;

import java.util.concurrent.RecursiveTask;

import static com.forkjoinpool.ForkJoin.COUNT_OF_OPERATION;
import static com.forkjoinpool.ForkJoin.NUMBER_OF_THREADS;

public class Recursion extends RecursiveTask<Long> {
    private long from;
    private long to;

    public Recursion(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        if ((to - from) <= COUNT_OF_OPERATION / NUMBER_OF_THREADS) {
            long result = 0;
            for (long i = from; i < to; i++) {
                result += i;
            }
            return result;
        } else {
            long middle = (to + from) / 2;
            Recursion firstHalf = new Recursion(from, middle);
            firstHalf.fork();
            Recursion secondHalf = new Recursion(middle + 1, to);
            long secondValue = secondHalf.compute();
            return firstHalf.join() + secondValue;
        }
    }
}

