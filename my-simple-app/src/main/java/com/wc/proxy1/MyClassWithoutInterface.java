package com.wc.proxy1;

/**
 * @author shovel
 * @date 2018/12/15 19:33
 * @since 1.0.0
 */
public class MyClassWithoutInterface {
    public int add(int a, int b) {
        System.out.println("a+b");
        return a + b;
    }

    public int reduce(int a, int b) {
        System.out.println("a-b");
        return a - b;
    }
}
