package com.wc.pattern.strategy;

/**
 * @author shovel
 * @date 2018/10/22 17:14
 * @since 1.0.0
 */
public class VipStrategy extends AbstractStrategy {
    @Override
    public void sell(String film, float price) {
        price = price * 0.5f;
        System.out.println("VIP购票:《" + film + "》，价格:" + price + "。积分" + price);
    }
}
