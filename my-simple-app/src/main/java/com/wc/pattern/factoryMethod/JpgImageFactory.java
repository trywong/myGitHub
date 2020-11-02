package com.wc.pattern.factoryMethod;

public class JpgImageFactory extends ImageFactory {
    @Override
    void readImage() {
        new JpgImage().readImage();
    }
}
