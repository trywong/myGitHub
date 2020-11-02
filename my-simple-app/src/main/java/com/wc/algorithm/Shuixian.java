package com.wc.algorithm;

public class Shuixian {
    public static boolean isShuixian(int num) {
        if (num < 100 || num > 999) {
            return false;
        }

        int index1 = num % 10;      // 个位
        int index2 = num / 10 % 10; // 十位
        int index3 = num / 100;     // 百位
        //System.out.println("个位：" + index1 + "   十位：" + index2 + "    百位：" + index3);
        if (num == Math.pow(index1, 3) + Math.pow(index2, 3) + Math.pow(index3, 3))
            return true;
        return false;
    }
    
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i ++) {
            if (isShuixian(i)) {
                System.out.println("--" + i);
            }
        }
    }
}
