package com.wc.thread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author shovel
 * @date 2018/12/28 10:47
 * @since 1.0.0
 */
public class VolatileTest {

    private int base = 0;

    // volatile保证修改变量值，其他线程立马可见
    private volatile boolean isStop = false;

    @Test
    public void volatileTest() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isStop) {
                    System.out.println("do something");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                isStop = true;
            }
        }).start();
    }

    @Test
    public void volatileIncrementTest() throws Exception {
        CountDownLatch latch = new CountDownLatch(100000);
        for (int i = 0; i < 100000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    base++;
                    latch.countDown();
                }
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 著名的缓存一致性问题：如果一个变量在多个CPU中都存在缓存（一般在多线程编程时才会出现），那么就可能存在缓存不一致的问题。
        // 即使加了volatile关键字，由于++操作分两步（读取，写入。在两步中间，另一线程读取了同样的值的情况下），在多个线程同时操作++操作时，导致每次输出的值不一样，但都小于50000，仍然产生了并发问题
        // 因为volatile关键字不保证原子性
        System.out.println(base);
    }
}
