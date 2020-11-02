package com.wc.pattern.strategy;

/**
 * @author shovel
 * @date 2018/10/22 17:11
 * @since 1.0.0
 */
public class StudentStrategy extends AbstractStrategy {
    @Override
    public void sell(String film, float price) {
        price = price * 0.8f;
        System.out.println("学生购票:《" + film + "》，价格:" + price);
    }
}
