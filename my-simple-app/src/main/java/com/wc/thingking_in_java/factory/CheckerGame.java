package com.wc.thingking_in_java.factory;

public class CheckerGame implements Game {

    public CheckerGame() {
        System.out.println("Checker game Constructor");
    }

    @Override
    public void move() {
        System.out.println("Checker game move..");
    }

}
