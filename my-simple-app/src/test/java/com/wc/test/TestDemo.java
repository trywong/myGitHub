package com.wc.test;

/**
 * @author shovel
 * @date 2018/12/28 17:06
 * @since 1.0.0
 */
public class TestDemo {
    static {
        System.out.println("father static");
    }

    public TestDemo() {
        System.out.println("father Constrctor");
    }

    public static void main(String[] args) {
        Child child = new Child();
    }
}

class Child extends TestDemo {
    public Child() {
        System.out.println("child Constructor");
    }
}
