package com.wc.pattern.abstractFactory.food;

public class KFCFactory implements IFastFoodFactory {

    @Override
    public IHamburger generateHamburger() {
        return new KFCHamburger();
    }

    @Override
    public IChicken generateChicken() {
        return new KFCChicken();
    }
}
