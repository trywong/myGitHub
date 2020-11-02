package com.wc;

/**
 * 移位运算
 * @author wangchuan
 * @since
 */
public class ShiftOperation {
    public static void main(String[] args) {
        System.out.println(abs1(-100));
    }

    /**
     * 偶数判断
     * ShiftOperation.printOdd()
     * @author wangchuan
     * @Date 2018年2月8日
     * @since
     * @param num
     */
    static void printOdd(int num) {
        for (int i = 0; i < num; i++) {
            // 二进制位末位为0则为偶数。等同于i%2==0
            if ((i & 1) == 0) {
                System.out.println(i);
            }
        }
    }

    /**
     * 交换数值
     * 第一步：
     * a = a ^ b
     * 第二步：一个数和自己异或的结果为0；任何数与0异或值不变。
     * b = b ^ a
     * b = b ^ (a ^ b)
     * b = b ^ b ^ a
     * b = 0 ^ a
     * b = a
     * 第三步：
     * a = a ^ b
     * a = (a ^ b) ^ (a)
     * a = a ^ a ^ b
     * a = b
     * ShiftOperation.swap()
     * @author wangchuan
     * @Date 2018年2月8日
     * @since
     * @param a
     * @param b
     */
    static void swap(int a, int b) {
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    /**
     * 正负数转换
     * 思路：二进制中，按位取反加1
     * ShiftOperation.reversal()
     * @author wangchuan
     * @Date 2018年2月8日
     * @since
     * @param num
     * @return
     */
    static int reversal(int num) {
        return ~num + 1;
    }

    /**
     * 绝对值
     * 第一步：取符号位
     * 第二步：如果符号位为0，则正数；如果符号位为-1，则为负数
     * ShiftOperation.abs()
     * @author wangchuan
     * @Date 2018年2月9日
     * @since
     * @param num
     * @return
     */
    static int abs(int num) {
        // 符号位
        int i = num >> 31;
        // 负数，输出11111111111111111111111111111111
        System.out.println(Integer.toBinaryString(i));
        return i == 0 ? num : (~num + 1);
    }

    /**
     * 不加任何逻辑判断的绝对值算法
     * 思路：-1与任意值与或，值为按位取反；正负转换是按位取反加1
     * ShiftOperation.abs1()
     * @author wangchuan
     * @Date 2018年2月9日
     * @since
     * @param num
     * @return
     */
    static int abs1(int num) {
        // 符号位
        int i = num >> 31;
        // 如果是正数，(num^0)-0 --> num
        // 如果是负数，(num^-1)-(-1) --> 按位取反+1 --> 转为正数
        return (num ^ i) - i;
    }
}
