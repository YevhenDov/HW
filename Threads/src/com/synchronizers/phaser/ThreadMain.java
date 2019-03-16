package com.synchronizers.phaser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

public class ThreadMain {
    private static final Phaser PHASER = new Phaser(1);
    private static List<Person> personList = new ArrayList<>();

    public static void main(String[] args){
        personList.add(new Person(1,6, PHASER));
        personList.add(new Person(3, 4, PHASER));
        personList.add(new Person(2, 5, PHASER));

        for (int i = 0; i < 7; i++){
            switch (i){
                case 0:
                    System.out.println("Start");
                    PHASER.arrive();
                    break;
                case 6:
                    System.out.println("Finish");
                    PHASER.arriveAndDeregister();
                    break;

                    default:
                        int now = PHASER.getPhase();
                        System.out.println("now on " + now);

                        for (Person person : personList){
                            if (person.in == now){
                                PHASER.register();
                                person.start();
                            }
                        }
                        PHASER.arriveAndAwaitAdvance();
            }
        }
    }
}
