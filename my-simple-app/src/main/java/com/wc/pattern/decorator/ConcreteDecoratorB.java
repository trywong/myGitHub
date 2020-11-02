package com.wc.pattern.decorator;

/**
 * <pre>
 *
 * </pre>
 *
 * @author wangchuan
 * @date 2018/9/11 15:26
 * @since 1.0.0
 */
public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addBehavior();

    }

    public void addBehavior() {
        System.out.println("ConcreteDecoratorB addBehavior");
    }
}
