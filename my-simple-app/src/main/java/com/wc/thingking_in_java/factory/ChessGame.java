package com.wc.thingking_in_java.factory;

public class ChessGame implements Game {

    public ChessGame() {
        System.out.println("Chess game Constructor");
    }

    @Override
    public void move() {
        System.out.println("Chess game move...");
    }

}
