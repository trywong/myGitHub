package com.wc.thread;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangchuan
 * @date 2020-02-29 09:13
 * @since 1.0.0
 */
public class ThreadPoolExecutorTest {
    @Test
    public void testThreadPoolExecutor() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(2), new ThreadFactory() {
            private final AtomicInteger mThreadNum = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread();
                int num = mThreadNum.getAndIncrement();
                t.setName("myThread_" + num);
                System.out.println("线程"+num+"被创建");
                return t;
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("拒绝策略" + r.toString());
            }
        });

        executor.prestartAllCoreThreads(); // 预启动所有核心线程
        try {
            for (int i = 0; i < 30; i++) {
                executor.execute(new MyTask(String.valueOf(i)));
                Thread.sleep(800);
            }

            System.in.read(); //阻塞主线程
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyTask implements Runnable {
        private String name;
        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println("执行线程" + this.toString());
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "task [name=" + this.name + "]";
        }
    }
}
