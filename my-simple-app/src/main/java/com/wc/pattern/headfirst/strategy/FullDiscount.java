package com.wc.pattern.headfirst.strategy;

/**
 * 满减折扣
 * @author shovel
 * @date 2018/11/1 15:42
 * @since 1.0.0
 */
public class FullDiscount implements Discount {
    // 满金额
    private double fullAmount;

    // 减金额
    private double fixedAmount;

    public FullDiscount(double fullAmount, double fixedAmount) {
        this.fullAmount = fullAmount;
        this.fixedAmount = fixedAmount;
    }


    @Override
    public double discountPrice(double originPrice) {
        if (originPrice > fullAmount) {
            return originPrice - fixedAmount;
        }
        return originPrice;
    }
}
