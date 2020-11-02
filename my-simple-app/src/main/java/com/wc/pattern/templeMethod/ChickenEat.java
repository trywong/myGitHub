package com.wc.pattern.templeMethod;

/**
 * @author shovel
 * @date 2018/10/22 18:00
 * @since 1.0.0
 */
public class ChickenEat extends AbstractEat {
    @Override
    protected void cook() {
        System.out.println("做鸡：杀鸡，拔毛，去内脏，红烧……");
    }

    @Override
    protected void anotherStep() {
        System.out.println("吃鸡时，额外的操作步骤");
    }
}
