package com.wc.thingking_in_java.factory;

public class ChessGameFactory implements GameFactory {

    @Override
    public Game getGame() {
        return new ChessGame();
    }

}
