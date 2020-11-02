package com.wc.thread;

import org.junit.Test;

/**
 * @author wangchuan
 * @date 2019-08-23 11:41
 * @since 1.0.0
 */
public class ThreadUtil {
    static void sleep(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @Test
    public void testUncaughtException() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running...");
            }
        });
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("uncaughtException里面catch到");
            }
        });
        thread.start();
    }

}
