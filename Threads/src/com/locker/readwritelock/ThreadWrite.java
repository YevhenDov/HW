package com.locker.readwritelock;

public class ThreadWrite extends Thread{
    @Override
    public void run() {

        Obj.lock.writeLock().lock();
        Obj.list.add("One");
        Obj.list.add("Two");
        Obj.list.add("Three");
        Obj.list.add("Four");
        Obj.lock.writeLock().unlock();

    }
}
