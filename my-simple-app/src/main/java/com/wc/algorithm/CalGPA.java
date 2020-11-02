package com.wc.algorithm;

import java.math.BigDecimal;

public class CalGPA {

    public static void main(String[] args) {
        String[] word = new String[] { "A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F" };
        Float[] score = new Float[] { 4.33F, 4.00F, 3.67F, 3.33F, 3.00F, 2.67F, 2.33F, 2.00F, 1.67F, 1.00F, 0F };
        BinarySearchST<String, Float> bs = new BinarySearchST<String, Float>(20);
        for (int i = 0; i < word.length; i++) {
            bs.put(word[i], score[i]);
        }

        String[] input = new String[] { "A+", "A", "B+", "A-", "C", "B+", "C", "A+", "A", "B+", "A", "B+", "A-", "C", "C-", "D", "C", "A+", "F" };
        float sum = 0;
        for (String level : input) {
            if (bs.get(level) != null) {
                sum += bs.get(level);
            }
        }

        System.out.println("sum=" + sum);
        BigDecimal sumDecimal = new BigDecimal(sum);
        BigDecimal countDecimal = new BigDecimal(input.length);
        // BigDecimal avgDecimal = sumDecimal.divide(countDecimal, 2, BigDecimal.ROUND_HALF_UP);
        // System.out.println("avg=" + avgDecimal.floatValue());
        BigDecimal avgDecimal = sumDecimal.divide(countDecimal);
        System.out.println("avg=" + avgDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
    }

}
