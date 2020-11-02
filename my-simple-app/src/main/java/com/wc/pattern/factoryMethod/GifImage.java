package com.wc.pattern.factoryMethod;

public class GifImage implements Image {

    @Override
    public void readImage() {
        System.out.println("read GIF");
    }
}
