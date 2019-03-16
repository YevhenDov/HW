package com.locker.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Obj {
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args){
        new ThreadFirst().start();
        new ThreadSecond().start();
    }

}
