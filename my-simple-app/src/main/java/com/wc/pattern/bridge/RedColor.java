package com.wc.pattern.bridge;

public class RedColor implements Color {

    @Override
    public void paintColor() {
        System.out.println("红色");
    }
}
