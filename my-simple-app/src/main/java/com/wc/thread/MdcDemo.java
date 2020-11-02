package com.wc.thread;

import org.slf4j.MDC;

/**
 * @author wangchuan
 * @date 2020-11-02 10:54
 * @since 1.0.0
 */
public class MdcDemo implements Runnable {
    public MdcDemo(String name) {
        Thread.currentThread().setName(name);
    }

    @Override
    public void run() {
        System.out.println("thread:" + Thread.currentThread().getName());
        System.out.println("put:" + Thread.currentThread().getName());
        MDC.put(Thread.currentThread().getName(), Thread.currentThread().getName());
        for (int j = 0; j < 100; j++) {
            if (j == 55) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        String value = MDC.get(Thread.currentThread().getName());
        System.out.println("get:" + value + "\n");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MdcDemo mdcThread1 = new MdcDemo("t" + i);
            mdcThread1.run();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}