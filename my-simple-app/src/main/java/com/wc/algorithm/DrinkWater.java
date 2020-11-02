package com.wc.algorithm;

public class DrinkWater {
    /**
     * 共有1000瓶汽水，每喝完后一瓶得到的一个空瓶子，每
     * 3个空瓶子又能换1瓶汽水，喝掉以后又得到一个空瓶子，问总共能喝多少瓶汽水，最后还剩余多少个空瓶子？
     * @History 2016年9月27日 上午11:29:34 by wangchuan
     */
    public static void drink(int count) {
        // 喝的瓶数
        int total = 0;
        // 空瓶
        int empty = 0;
        while (count > 0) {
            total++;// 喝了一瓶
            empty++;// 空瓶增加1
            count--;// 数量减少1
            if (empty == 3) {
                count++;
                empty = 0;
            }
        }
        System.out.println("总：" + total);
        System.out.println("剩余：" + empty);
    }

    public static void main(String[] args) {
        drink(1000);
    }
}
