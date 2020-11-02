package com.wc.pattern.memento;

import java.util.LinkedList;

/**
 * 备忘录管理者
 * @author shovel
 * @date 2018/10/16 15:37
 * @since 1.0.0
 */
public class MementoManager {
    private LinkedList<ChessmanMemento> mementos;

    public ChessmanMemento getMemento() {
        ChessmanMemento memento = mementos.getLast();
        mementos.removeLast();
        return memento;
    }

    public void addMemento(ChessmanMemento memento) {
        if (mementos == null) {
            mementos = new LinkedList<>();
        }
        mementos.add(memento);
    }
}
