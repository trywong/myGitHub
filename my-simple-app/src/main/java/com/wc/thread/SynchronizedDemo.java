package com.wc.thread;

public class SynchronizedDemo implements Runnable {
    int a = 0;

    public synchronized void increasement() {
        a++;
    }


    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            increasement();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo runnable = new SynchronizedDemo();

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(runnable.a);
    }
}

