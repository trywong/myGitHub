package com.wc.pattern.visit;

/**
 * 抽象元素
 * @author shovel
 * @date 2018/10/23 11:25
 * @since 1.0.0
 */
public abstract class AbstractElement {
    public abstract void accept(AbstractVisitor visitor);
}
