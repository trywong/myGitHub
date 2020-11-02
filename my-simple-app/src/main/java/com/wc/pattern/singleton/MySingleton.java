package com.wc.pattern.singleton;

/**
 * @author wangchuan
 * @date 2019-04-04 10:14
 * @since 1.0.0
 */
public class MySingleton {
    private static MySingleton instance = null;

    private MySingleton() {
    }

    public MySingleton getInstance() {
        if (instance == null) {
            synchronized (this) {
                if (instance == null) {
                    instance = new MySingleton();
                }
            }
        }

        return instance;
    }
}
