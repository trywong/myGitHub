package com.wc.pattern.headfirst.strategy;

/**
 * 按百分比折扣
 * @author shovel
 * @date 2018/11/1 15:38
 * @since 1.0.0
 */
public class PercentDiscount implements Discount {

    private double percent;

    public PercentDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double discountPrice(double originPrice) {
        return originPrice * percent;
    }
}
