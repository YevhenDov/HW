package com.reflection;

import com.singleton.Singleton;
import java.lang.reflect.Constructor;

public class Reflection {
    static Singleton instance = null;

    public static Singleton Hack() {

        try {
            Constructor[] constructors = Singleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instance = (Singleton) constructor.newInstance();
                break;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return instance;
    }

    public static void main(String[] args) throws Exception{
        new Reflection().Hack();
    }
}
