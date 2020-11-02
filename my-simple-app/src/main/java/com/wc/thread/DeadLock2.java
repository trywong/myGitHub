package com.wc.thread;

/**
 * @author wangchuan
 * @date 2019-09-02 15:05
 * @since 1.0.0
 */
public class DeadLock2 {
    public static Object obj1 = new Object();
    public static Object obj2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        thread1.start();
        thread2.start();
    }
}

/**
 * Thread1持有锁obj1，想获得锁obj2
 */
class Thread1 implements Runnable {

    @Override
    public void run() {
        System.out.println("thread1 running");
        synchronized (DeadLock2.obj1) {
            System.out.println("thread1 got lock1, waiting for lock2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLock2.obj2) {
                System.out.println("thread1 got lock2");
            }
        }
    }
}

/**
 * Thread2持有锁obj2，想获得锁obj1
 */
class Thread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("thread2 running");
        synchronized (DeadLock2.obj2) {
            System.out.println("thread2 got lock2, waiting for lock1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLock2.obj1) {
                System.out.println("thread2 got lock1");
            }
        }
    }
}
