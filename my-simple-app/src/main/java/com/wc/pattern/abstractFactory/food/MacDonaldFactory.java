package com.wc.pattern.abstractFactory.food;

public class MacDonaldFactory implements IFastFoodFactory {

    @Override
    public IHamburger generateHamburger() {
        return new MacDonaldHamburger();
    }

    @Override
    public IChicken generateChicken() {
        return new MacDonaldChicken();
    }
}
