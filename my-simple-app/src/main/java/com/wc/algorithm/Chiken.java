package com.wc.algorithm;

import java.math.BigDecimal;

public class Chiken {
    /**
     * 母鸡3元/只，公鸡4元/只，小鸡0.5元/只；用100元买100只鸡的可能组合
     * @History 2016年9月27日 上午11:06:17 by wangchuan
     */
    public static void buyChiken() {
        final float goalAmount = 100f;
        final int goalCount = 100;
        // 母鸡数量，总价100元限制，最多100/3只；
        for (int j = 1; j <= 100 / 3; j++) {
            // 公鸡数量，总价100元限制，最多100/4只；
            for (int k = 1; k <= 100 / 4; k++) {
                // 小鸡数量，数量限制，最多100只；
                int i = goalCount - j - k;
                BigDecimal femalePrice = new BigDecimal("3");// 母鸡单价
                BigDecimal malePrice = new BigDecimal("4");// 公鸡单价
                BigDecimal littlePrice = new BigDecimal("0.5");// 小鸡单价
                BigDecimal femaleMulti = femalePrice.multiply(new BigDecimal(j + ""));
                BigDecimal maleMulti = malePrice.multiply(new BigDecimal(k + ""));
                BigDecimal littleMulti = littlePrice.multiply(new BigDecimal(i + ""));
                float amount = femaleMulti.add(maleMulti).add(littleMulti).floatValue();
                if (i >= 0 && amount == goalAmount) {
                    System.out.println("小鸡：" + i + "；母鸡：" + j + "；公鸡：" + k);
                }
            }
        }
    }

    public static void main(String[] args) {
        buyChiken();
    }
}
