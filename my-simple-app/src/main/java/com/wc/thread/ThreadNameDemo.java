package com.wc.thread;

/**
 * @author shovel
 * @date 2018/12/28 14:06
 * @since 1.0.0
 */
public class ThreadNameDemo {
    public static void main(String[] args) {
        System.out.println("main start");

        Thread.currentThread().setName("main tread");

        OperationThread operationThread = new OperationThread();
        operationThread.setName("operationThread");
        operationThread.start();

        System.out.println("main end");

        /**
         * 输出：
         * main start
         * constructor start
         * in constructor: Thread.currentThread.getName=main tread
         * in constructor: this.getName=Thread-0
         * constructor end
         * main end
         *
         * run start
         * in run: Thread.currentThread.getName=operationThread
         * in run: this.getName=operationThread     // 此处与constructor中不同，因为在构造函数之后，设置了name
         * run end
         */
    }
}

class OperationThread extends Thread {
    public OperationThread() {
        System.out.println("constructor start");
        // 当前被哪个线程调用，构造函数在main线程中调用
        System.out.println("in constructor: Thread.currentThread.getName=" + Thread.currentThread().getName());
        System.out.println("in constructor: this.getName=" + this.getName());
        System.out.println("constructor end");
    }

    @Override
    public void run() {
        System.out.println("run start");

        // 当前被哪个线程调用，run()在operationThread.start()之后调用，由operationThread线程调用
        System.out.println("in run: Thread.currentThread.getName=" + Thread.currentThread().getName());
        // OperationThread的线程实例名operationThread
        System.out.println("in run: this.getName=" + this.getName());

        System.out.println("run end");
    }
}
