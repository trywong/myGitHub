package com.wc.pattern.headfirst.singleton;

/**
 * @author shovel
 * @date 2018/11/7 11:03
 * @since 1.0.0
 */
public class Singleton {
    // 当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。----可见性
    private volatile static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        // 防止已经实例化instance后，每次依然同步，降低程序执行效率
        /*if (instance == null) {
            synchronized (Singleton.class) {
                // 防止多线程执行，创建多个实例
                if (instance == null) {
                    System.out.println("创建实例" + Thread.currentThread().getName());
                    instance = new Singleton();
                }
            }
        }*/

        /* 有问题版本
        if (instance == null) {
            System.out.println("创建实例" + Thread.currentThread().getName());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton();
        }*/

        System.out.println("返回实例" + Thread.currentThread().getName());
        return instance;
    }
}
