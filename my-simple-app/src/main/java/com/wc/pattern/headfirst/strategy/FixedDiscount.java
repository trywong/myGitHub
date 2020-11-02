package com.wc.pattern.headfirst.strategy;

/**
 * 固定减金额
 * @author shovel
 * @date 2018/11/1 15:40
 * @since 1.0.0
 */
public class FixedDiscount implements Discount {
    private double fixedAmount;

    public FixedDiscount(double fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    @Override
    public double discountPrice(double originPrice) {
        double result = originPrice - fixedAmount;
        return result > 0 ? result : 0;
    }
}
