package com.wc.pattern.singleton;

/**
 * 懒汉式单例---有非线程安全问题
 * @author wangchuan
 * @since V3.1.0
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("构造单例过程");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            System.out.println("第一次创建");
            instance = new Singleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("singleton do something");
    }

    public void doAnotherthing() {
        System.out.println("singleton do anotherthing");
    }
}
