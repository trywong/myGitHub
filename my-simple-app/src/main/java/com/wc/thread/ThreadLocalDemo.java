package com.wc.thread;

/**
 * @author wangchuan
 * @date 2020-08-13 10:42
 * @since 1.0.0
 */
public class ThreadLocalDemo {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("thread1 do do");
                System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
            }
        }, "thread-1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("thread2 do do");
                System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
            }
        }, "thread-2");

        threadLocal.set("main dodo");

        thread1.start();
        thread2.start();

        System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
    }
}
