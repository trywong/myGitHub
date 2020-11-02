package com.wc.thingking_in_java.testextends;

public class Level2 extends Level1 {
    private int radius = 1;
    
    public Level2() {
        this.radius = 32;
    }

    void draw() {
        System.out.println("Level2.draw(), radius=" + radius);
    }

    public void ownMethod() {
        System.out.println("ownMethod()");
    }

    public static void main(String[] args) {
        new Level2().draw();
    }
}
