package com.locker.lock;

public class ThreadFirst extends Thread {

    @Override
    public void run() {

        Obj.lock.lock();

        System.out.println(getName() + " Start working");
        try {
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " Stop working");

        Obj.lock.unlock();

    }
}
