package com.wc.pattern.abstractFactory.tec;

public class MiFactory implements TecFactory {

    @Override
    public Television createTV() {
        return new MiTelevision();
    }

    @Override
    public WashMachine createWashMachine() {
        return new MiWashMachine();
    }
}
