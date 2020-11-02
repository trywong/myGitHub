package com.wc.pattern.factoryMethod;

public class GifImageFactory extends ImageFactory {

    @Override
    void readImage() {
        new GifImage().readImage();
    }
}
