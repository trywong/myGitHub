package com.wc.thread;

/**
 * 死锁
 * @author shovel
 * @date 2018/12/20 19:25
 * @since 1.0.0
 */
public class DeadLock {
    Object obj = new Object();

    // method1中，obj锁需要持有this锁才能完成任务
    // method2中，this锁需要持有obj锁才能完成任务
    public void method1() {
        synchronized (obj) {    //obj锁
            this.method2();  // this锁
            System.out.println("method1");
        }
    }

    public synchronized void method2() {    // this锁
        synchronized (obj) {        // obj锁
            System.out.println("method2");
        }
    }
}
