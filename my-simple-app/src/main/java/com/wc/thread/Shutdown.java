package com.wc.thread;

public class Shutdown {

    public static void main(String[] args) throws Exception {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();        // 睡眠1秒，main线程对CountThread进行中断，使CountThread能够感知中断而结束
        ThreadUtil.sleep(3);
        countThread.interrupt();
        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();
        // 睡眠1秒，main线程对Runner two进行取消，使CountThread能够感知on为false而结束
        ThreadUtil.sleep(3);
        two.cancel();
    }

    private static class Runner implements Runnable {        
        private long i;            
        private volatile boolean on = true;            
        @Override            
        public void run() {            
            while (on && !Thread.currentThread().isInterrupted()){                  
                i++;
                System.out.println("thread:" + Thread.currentThread().getName() + " is running");
                try {
                    ThreadUtil.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }    
            System.out.println("Count i = " + i);       
        }        
        public void cancel() {            
            on = false;        
        }    
    }
}