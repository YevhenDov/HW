package com.locker.readwritelock;

public class ThreadRead extends Thread {

    @Override
    public void run() {
        Obj.lock.readLock().lock();
        for (int i = 0; i < Obj.list.size(); i++) {
            System.out.println(Obj.list.get(i));
        }
    }
}
