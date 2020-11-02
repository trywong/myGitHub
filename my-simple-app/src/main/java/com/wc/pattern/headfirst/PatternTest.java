package com.wc.pattern.headfirst;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.wc.pattern.headfirst.singleton.Singleton;

/**
 * @author shovel
 * @date 2018/11/1 15:46
 * @since 1.0.0
 */
public class PatternTest {
    public static void main(String[] args) {
        /**策略模式*/
        /*Book effectiveJava = new Book("Effective Java", 22.4);
        Book thinkingInJava = new Book("Java编程思想", 188.7);
        Book keepAlive = new Book("活着", 143.5);
        Book thatMan = new Book("那人", 19.9);
        Book learnEnglish = new Book("英语学习", 126.8);
        Book learnChinease = new Book("汉语学习", 29.8);

        Discount percentDiscount = new PercentDiscount(0.9);
        Discount fixedDiscount = new FixedDiscount(2);
        Discount fullDicount = new FullDiscount(100, 10);

        *//**
         * 设置不同的折扣，售价就按照折扣规则计算
         *//*
        effectiveJava.setDiscount(percentDiscount);
        thinkingInJava.setDiscount(percentDiscount);

        keepAlive.setDiscount(fixedDiscount);
        thatMan.setDiscount(fixedDiscount);

        learnEnglish.setDiscount(fullDicount);
        learnChinease.setDiscount(fullDicount);

        effectiveJava.sell();
        thinkingInJava.sell();
        keepAlive.sell();
        thatMan.sell();
        learnEnglish.sell();
        learnChinease.sell();*/


        /**
         * 装饰模式
         */
        /*AbstractCoffee typeACoffee = new TypeACoffee("摩卡");
        typeACoffee.setSize(AbstractCoffee.SIZE_GRANDE);
        // 用“牛奶”装饰
        typeACoffee = new MilkDecorator(typeACoffee);
        // 再用“牛奶”装饰一遍
        typeACoffee = new MilkDecorator(typeACoffee);
        // 用“糖”装饰
        typeACoffee = new SugerDecorator(typeACoffee);
        System.out.println(typeACoffee.description() + ", 价格: " + typeACoffee.cost());*/

        /**
         * 单例模式
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        for (int i = 0; i < 50; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    Singleton singleton = Singleton.getInstance();
                }
            });
        }

    }
}
