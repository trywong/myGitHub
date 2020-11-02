package com.wc.algorithm;

public class Rabbit {
    /*
     * 有一对兔子，从出生后第3个月起每个月都生一对兔子，
     * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少
     */

    public static void main(String[] args) {
        final int MONTH = 15;
        for (int i = 1; i <= MONTH; i++) {
            System.out.println("第" + i + "个月兔子数：" + bornRabbit(i));
        }
    }
    
    public static int bornRabbit(int month) {
        if (month == 1 || month == 2) {
            return 1;
        } else {
            return bornRabbit(month - 1) + bornRabbit(month - 2);
        }
    }
}
