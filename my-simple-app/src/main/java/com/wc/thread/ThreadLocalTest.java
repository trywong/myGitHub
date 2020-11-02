package com.wc.thread;

import org.junit.Test;

/**
 * @author shovel
 * @date 2018/12/27 15:43
 * @since 1.0.0
 */
public class ThreadLocalTest {
    @Test
    public void threadLocalTest() throws InterruptedException {
        // set的值，可以在子线程中get
        ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        inheritableThreadLocal.set("hello, shovel");

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable(){
                /*ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
                    @Override
                    protected String initialValue() {
                        return Thread.currentThread().getName();
                    }
                };*/

                ThreadLocal<String> threadLocal = new ThreadLocal<>();
                @Override
                public void run() {
                    threadLocal.set("info in run");

                    System.out.println("threadLocal.get()->" + threadLocal.get());

                    System.out.println("from super thread: " + inheritableThreadLocal.get());

                    this.method1();
                    this.method2();
                }

                public void method1() {
                    System.out.println("method1.get: " + threadLocal.get());
                }

                public void method2() {
                    System.out.println("method2.get: " + threadLocal.get());
                }
            }).start();
        }

        Thread.sleep(2000);
        System.out.println("end");
    }
}
