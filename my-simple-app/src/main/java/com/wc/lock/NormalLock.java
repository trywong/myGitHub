package com.wc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author wangchuan
 * @date 2020-08-07 14:29
 * @since 1.0.0
 */
public class NormalLock implements Lock {

    /**
     * 利用AQS，实现自定义锁
     */
    private static class MyLock extends AbstractQueuedSynchronizer {
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        @Override
        protected boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int release) {
            if (getState() == 0) {
                throw  new IllegalMonitorStateException();
            }

            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }

    private MyLock myLock = new MyLock();

    @Override
    public void lock() {
        myLock.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        myLock.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return myLock.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return myLock.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        myLock.release(1);
    }

    @Override
    public Condition newCondition() {
        return myLock.newCondition();
    }

}
