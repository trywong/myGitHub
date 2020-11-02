package com.wc.pattern.simpleFactory;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("画圆形");
    }

    @Override
    public void erase() {
        System.out.println("擦除圆形");
    }
}
