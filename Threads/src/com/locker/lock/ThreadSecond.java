package com.locker.lock;

public class ThreadSecond extends Thread {

    @Override
    public void run() {
        System.out.println(getState() + " start");
        while (true){
            if (Obj.lock.tryLock()){
                System.out.println(getName() + " already is working");
                break;
            }else{
                System.out.println(getName() + " waiting");
            }
        }
    }
}
