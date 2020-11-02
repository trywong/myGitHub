package com.wc.pattern.factoryMethod;

public class CircleButtonFactory implements ShapeFactory {

    @Override
    public Button generateButton() {
        return new CircleButton();
    }
}