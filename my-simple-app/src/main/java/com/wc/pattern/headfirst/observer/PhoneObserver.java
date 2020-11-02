package com.wc.pattern.headfirst.observer;

/**
 * @author shovel
 * @date 2018/11/1 11:36
 * @since 1.0.0
 */
public class PhoneObserver implements Observer {
    @Override
    public void update(int temprature, int rain) {
        System.out.println("手机更新数据, temprature:" + temprature + ", rain:" + rain);
    }
}
