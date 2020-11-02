package com.wc.pattern.templeMethod;

/**
 * @author shovel
 * @date 2018/10/22 17:57
 * @since 1.0.0
 */
public class NoodleEat extends AbstractEat {
    @Override
    protected void cook() {
        System.out.println("下面条，先烧开水，再煮面条");
    }

    @Override
    protected void anotherStep() {
    }

    @Override
    protected boolean hook() {
        System.out.println("吃面条时，不需要额外步骤");
        return false;
    }
}
