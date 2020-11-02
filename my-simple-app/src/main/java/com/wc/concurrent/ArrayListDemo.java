package com.wc.concurrent;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author wangchuan
 * @date 2020-08-14 10:49
 * @since 1.0.0
 */
public class ArrayListDemo {

    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    //static List<Integer> list = Lists.newArrayList();
    static List<Integer> list = Lists.newCopyOnWriteArrayList();

    static final int MAX = 1000;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < MAX; i += 3) {
                    list.add(i);
                }
                countDownLatch.countDown();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < MAX; i += 3) {
                    list.add(i);
                }
                countDownLatch.countDown();
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 2; i < MAX; i += 3) {
                    list.add(i);
                }
                countDownLatch.countDown();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        countDownLatch.await();

        System.out.println(list);
        System.out.println(list.size());

    }
}
