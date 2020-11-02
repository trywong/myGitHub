package com.wc.thingking_in_java.teststatic;

public abstract class Cow {
    public static void eat() {
        Plant.leaves();
        System.out.println("Cow eat leaves");
    }

    public abstract void sleep();
}
