package com.wc.pattern.abstractFactory.food;

public class DicosFactory implements IFastFoodFactory {

    @Override
    public IHamburger generateHamburger() {
        return new DicosHamburger();
    }

    @Override
    public IChicken generateChicken() {
        return new DicosChicken();
    }
}
