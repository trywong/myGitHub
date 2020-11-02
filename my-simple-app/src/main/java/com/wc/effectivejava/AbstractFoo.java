package com.wc.effectivejava;

import java.util.concurrent.atomic.AtomicReference;

public class AbstractFoo {
    private int x;
    private int y;

    public enum State {
        NEW,
        INITIALIZING,
        INITIALIZED
    }

    private final AtomicReference<State> reference = new AtomicReference<State>();

    public AbstractFoo(int x, int y) {
        initialize(x, y);
    }

    public AbstractFoo() {
    }

    private final void initialize(int x, int y) {
        if (!reference.compareAndSet(State.NEW, State.INITIALIZING)) {
            throw new IllegalStateException("Already initialized...");
        }
        this.x = x;
        this.y = y;
        reference.set(State.INITIALIZED);
    }

    public int getX() {
        checkInit();
        return x;
    }

    public int getY() {
        checkInit();
        return y;
    }

    private void checkInit() {
        if (State.INITIALIZED != reference.get()) {
            throw new IllegalStateException("Uninitialized...");
        }
    }
}
