package com.concurrent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWrite {
    private static List<String> lst = new CopyOnWriteArrayList<>();

    public static void main(String[] args){
        lst.add("One");
        lst.add("Two");
        lst.add("Three");
        lst.add("Four");

        new Thread(() -> {
            for (int i = 0; i < lst.size(); i++){
                String threadFirst = lst.get(i);
                System.out.println(threadFirst);
            }
        }).start();

        new Thread(() -> {
            System.out.println("================");
            lst.add("Five");
            lst.add("Six");
            for (int i = 0; i < lst.size(); i++){
                String threadSecond = lst.get(i);
                System.out.println(threadSecond);
            }
        }).start();
    }
}
