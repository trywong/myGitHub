package com.wc.thingking_in_java.factory;

public class CheckerGameFactory implements GameFactory {

    @Override
    public Game getGame() {
        return new CheckerGame();
    }

}
