package com.wc.algorithm;

/**
 * 最大公约数
 * @Description TODO
 * @author wangchuan E-mail:wulacao@7lk.com
 * @version 2016年9月21日 下午4:34:35
 */
public class GongYueShu {
    public static int maxGongYue(int num1, int num2) {
        int max = 1;
        int len = 0;
        /*
         * 只循环一半，作为被除数
         */
        if (num1 < num2) {
            len = (num2 / 2) >= num1 ? num1 : (num2 / 2);
        } else {
            len = (num1 / 2) >= num2 ? num2 : (num1 / 2);
        }
        System.out.println("len = " + len);
        for (int i = 1; i <= len; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxGongYue(10, 30));
    }
}
