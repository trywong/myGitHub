package com.wc.pattern.factoryMethod;

public class SquareButtonFactory implements ShapeFactory {

    @Override
    public Button generateButton() {
        return new SquareButton();
    }
}