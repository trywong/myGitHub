package com.wc.pattern.templeMethod;

/**
 * @author shovel
 * @date 2018/10/22 17:57
 * @since 1.0.0
 */
public class FishEat extends AbstractEat {
    @Override
    protected void cook() {
        System.out.println("做鱼：剖腹，去内脏，烧开水……");
    }

    @Override
    protected void anotherStep() {
        System.out.println("吃鱼时，额外的操作步骤");
    }
}
