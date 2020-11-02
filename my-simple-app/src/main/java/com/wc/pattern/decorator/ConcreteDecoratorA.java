package com.wc.pattern.decorator;

public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addBehavior();
    }

    public void addBehavior() {
        System.out.println("ConcreteDecoratorA add Behavior");
    }
}