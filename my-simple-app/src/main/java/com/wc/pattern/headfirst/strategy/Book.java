package com.wc.pattern.headfirst.strategy;

/**
 * @author shovel
 * @date 2018/11/1 15:26
 * @since 1.0.0
 */
public class Book {
    protected double originPrice;
    protected Discount discount;
    private String name;

    public Book(String name, double originPrice) {
        this.name = name;
        this.originPrice = originPrice;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    double getOriginPrice() {
        return originPrice;
    }

    /**
     * 折扣价计算方式
     *
     * @return
     */
    double discountPrice() {
        return discount.discountPrice(originPrice);
    }

    public void sell() {
        System.out.println("图书:" + name + "，原价：" + originPrice + ", 折扣价：" + this.discountPrice());
    }
}
