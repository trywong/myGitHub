package com.wc.pattern.strategy;

/**
 * 抽象策略
 * @author shovel
 * @date 2018/10/22 17:09
 * @since 1.0.0
 */
public abstract class AbstractStrategy {
    /**
     * 销售方式
     * @param film 电影名
     * @param price 原价
     */
    public abstract void sell(String film, float price);
}
