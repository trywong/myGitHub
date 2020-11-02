package com.wc.pattern.simpleFactory;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("画方形");
    }

    @Override
    public void erase() {
        System.out.println("擦除方形");
    }
}
