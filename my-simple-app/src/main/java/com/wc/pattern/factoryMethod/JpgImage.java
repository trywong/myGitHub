package com.wc.pattern.factoryMethod;

public class JpgImage implements Image {

    @Override
    public void readImage() {
        System.out.println("read JPG");
    }
}
