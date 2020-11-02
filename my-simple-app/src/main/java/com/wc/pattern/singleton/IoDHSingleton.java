package com.wc.pattern.singleton;

/**
 * IoDH单例
 * Initialization Demand Holder (IoDH)
 * @author wangchuan
 */
public class IoDHSingleton {
    private IoDHSingleton() {
    }

    /**
     * 静态内部类持有单例对象
     * @author wangchuan
     */
    private static class InstanceHolder {
        private static final IoDHSingleton instance = new IoDHSingleton();
    }

    public IoDHSingleton getInstance() {
        return InstanceHolder.instance;
    }
}
