package com.wc.pattern.composite;

public abstract class Component {
    protected String name;

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract void display();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
