package com.wc.thread;

public class RunnableDemo {
    private int val;
    private Object object = new Object();

    /*public RunnableDemo(int val) {
        System.out.println("creating " + Thread.currentThread().getName());
        this.val = val;
    }

    @Override
    public void run() {
        System.out.println("Runing " + Thread.currentThread().getName());
        this.reduce();
    }

    public void reduce() {
        while (this.val > 0) {
            this.val--;
            System.out.println(Thread.currentThread().getName() + " remain:" + this.getVal());
        }
    }*/

    public int getVal() {
        return this.val;
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                val++;
                System.out.println(this.getName() + "-" + val);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        RunnableDemo demo = new RunnableDemo();
        Thread thread1 = demo.new MyThread();
        Thread thread2 = demo.new MyThread();

        thread1.start();
        thread2.start();
    }
}