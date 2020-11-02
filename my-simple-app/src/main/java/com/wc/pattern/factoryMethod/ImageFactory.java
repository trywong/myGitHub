package com.wc.pattern.factoryMethod;

public abstract class ImageFactory {
    abstract void readImage();

    public void showImage() {

        readImage();

        System.out.println("show image.");
    }
}
