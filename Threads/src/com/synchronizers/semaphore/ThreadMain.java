package com.synchronizers.semaphore;

import java.util.concurrent.Semaphore;

public class ThreadMain {
    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        Obj obj0 = new Obj(semaphore);
        Obj obj1 = new Obj(semaphore);
        Obj obj2 = new Obj(semaphore);
        Obj obj3 = new Obj(semaphore);

        obj0.start();
        obj1.start();
        obj2.start();
        obj3.start();
    }
}
