package com.wc.thread;

/**
 * @author shovel
 * @date 2018/12/29 11:11
 * @since 1.0.0
 */
public class SynchronizedTestDemo implements Runnable {
    static SynchronizedTestDemo instance = new SynchronizedTestDemo();
    static int a = 0;

    public  void  increasement() {
        a++;
    }

    @Override
    public void run() {
        synchronized(instance) {
            for (int i = 0; i < 50000; i++) {
                this.increasement();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(a);
    }
}
