package com.wc.pattern.decorator;

/**
 * <pre>
 *
 * </pre>
 *
 * @author wangchuan
 * @date 2018/9/11 15:10
 * @since 1.0.0
 */
public abstract class Decorator implements Component {

    Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}
