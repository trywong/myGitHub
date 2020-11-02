package com.wc.pattern.abstractFactory.tec;

public class HaierFactory implements TecFactory {

    @Override
    public Television createTV() {
        return new HaierTelevision();
    }

    @Override
    public WashMachine createWashMachine() {
        return new HaierWashMachine();
    }
}
