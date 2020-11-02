package com.wc.thingking_in_java.factory;

import com.wc.thingking_in_java.innerclass.OuterClass;

public class TestGame {
    public static void main(String[] args) {
        playGame(new CheckerGameFactory());
        playGame(new ChessGameFactory());

        OuterClass.InnerClass in = new OuterClass().new InnerClass();
    }

    static void playGame(GameFactory factory) {
        Game game = factory.getGame();
        game.move();
    }
}
