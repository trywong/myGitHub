package com.wc.thread;

/**
 * @author shovel
 * @date 2018/12/21 11:19
 * @since 1.0.0
 */
public class InterruptDemo {
    static class SleepThread extends Thread {

        public SleepThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                System.out.printf("%s loop...", this.getName()).println();
                try {
                    Thread.sleep(3 * 1000);
                } catch (InterruptedException e) {
                    System.out.printf("%s break...", this.getName()).println();
                    break;
                }
            }

            System.out.printf("%s end...", this.getName()).println();
        }
    }

    // 中断sleep状态的线程
    public static void testSleep() {
        System.out.println("InterruptTest.testSleep()");
        SleepThread t = new SleepThread("SleepThread");
        t.start();
        try {
            Thread.sleep(7 * 1000);
        } catch (InterruptedException e) {
            // ignore
        }

        // 调用interrupt，SleepThread从sleep状态抛出InterruptedException，处理后结束线程
        t.interrupt();
    }


    static class WaitThread extends Thread {
        private Object waitObject = new Object();

        public WaitThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (waitObject) {
                try {
                    System.out.printf("%s 进入wait阻塞...", this.getName()).println();
                    waitObject.wait();
                    System.out.printf("%s 结束wait阻塞...", this.getName()).println();
                } catch (InterruptedException e) {
                    System.out.printf("%s Interrupted...", this.getName()).println();
                }
                System.out.printf("%s Business after wait...", this.getName()).println();
            }
            System.out.printf("%s 结束", this.getName()).println();
        }
    }

    // 中断wait状态的线程
    public static void testWait() {
        System.out.println("InterruptTest.testWait()");
        WaitThread t = new WaitThread("WaitThread");
        t.start();
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            // ignore
        }
        t.interrupt();
        // System.out.println();
    }

    static class JoinThread extends Thread {
        // 调用jointhread.join的线程，需要在这里对其进行中断
        private Thread callJoinThread;

        public JoinThread(String name, Thread callJoinThread) {
            super(name);
            this.callJoinThread = callJoinThread;
        }

        @Override
        public void run() {
            int max = 1000000;
            for (int i = 0; i < max; i++) {
                //
            }
            System.out.printf("%s step1...", this.getName()).println();
            callJoinThread.interrupt(); // 中断阻塞在join的线程
            for (int i = 0; i < max; i++) {
                //
            }
            System.out.printf("%s step2...", this.getName()).println();
            System.out.printf("%s 结束", this.getName()).println();
        }
    }

    public static void testJoin() {
        System.out.println("InterruptTest.testJoin()");
        JoinThread jt = new JoinThread("JoinThread", Thread.currentThread());
        jt.start();

        try {
            jt.join();
        } catch (InterruptedException e) {
            System.out.printf("%s 被中断，从join中返回...", Thread.currentThread().getName()).println();
        }
    }

    public static void main(String[] args) {
        /**
         * InterruptTest.testSleep()
         * SleepThread loop...
         * SleepThread loop...
         * SleepThread loop...
         * SleepThread break...
         * SleepThread end...
         */
        // testSleep();

        /**
         * InterruptTest.testWait()
         * WaitThread 进入wait阻塞...
         * WaitThread Interrupted...
         * WaitThread Business after wait...
         * WaitThread 结束
         */
        //testWait();

        /**
         * InterruptTest.testJoin()
         * JoinThread step1...
         * main 被中断，从join中返回...
         * JoinThread step2...
         * JoinThread 结束
         */
        testJoin();
    }
}
