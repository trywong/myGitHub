package com.wc.thingking_in_java.teststatic;

public class BlackCow extends Cow {

    @Override
    public void sleep() {
        System.out.println("black cow sleep....");
    }

    public static void main(String[] args) {
        eat();
        Plant.leaves();
        Plant plant = new Plant();
    }
}
