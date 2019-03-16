package com.locker.readwritelock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Obj {
    public static List<String> list = new ArrayList<>();
    public static ReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        new ThreadWrite().start();
        new ThreadRead().start();

    }
}
