package com.threadpoolexecutor;

import java.util.concurrent.Callable;

public class Multiply implements Callable<Integer> {
    private int valueForMultiply;

    public Multiply() {

    }

    public Multiply(int valueForMultiply) {
        this.valueForMultiply = valueForMultiply;
    }

    @Override
    public Integer call() {
        return valueForMultiply * valueForMultiply;
    }
}