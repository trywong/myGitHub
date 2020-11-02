package com.wc.pattern.strategy;

/**
 * @author shovel
 * @date 2018/10/22 17:16
 * @since 1.0.0
 */
public class NormalStrategy extends AbstractStrategy {
    @Override
    public void sell(String film, float price) {
        System.out.println("购票:《" + film + "》，价格:" + price);
    }
}
