package com.wc.thingking_in_java.testextends;

public class Level3 {
    public Level3() {
    }

    public static void main(String[] args) {
        Level1 l2 = new Level2();
        l2.draw();
        ((Level2) l2).ownMethod();
    }
}
