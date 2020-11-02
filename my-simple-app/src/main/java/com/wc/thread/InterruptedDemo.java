package com.wc.thread;

/**
 * @author wangchuan
 * @date 2019-08-23 11:36
 * @since 1.0.0
 */
public class InterruptedDemo {
    public static void main(String[] args) throws Exception {
        Runner one = new Runner();
        Thread threadOne = new Thread(one, "one");
        threadOne.start();

        ThreadUtil.sleep(3);

        threadOne.interrupt();

        Runner two = new Runner();
        threadOne = new Thread(one, "two");
        threadOne.start();

        ThreadUtil.sleep(3);
        two.cancel();

        ThreadUtil.sleep(3);
    }

    private static class Runner implements Runnable {

        private volatile boolean runing = true;

        private  long count = 0;

        @Override
        public void run() {
            while (runing && !Thread.currentThread().isInterrupted()) {
                count++;

                System.out.println("thread:" + Thread.currentThread().getName() + " is running");

                try {
                    ThreadUtil.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("count=" + count);
        }

        public long getCount() {
            return count;
        }

        public void cancel() {
            runing = false;
        }
    }
}


