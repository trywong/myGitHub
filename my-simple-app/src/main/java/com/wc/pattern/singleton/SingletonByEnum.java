package com.wc.pattern.singleton;

/**
 * @author wangchuan
 * @date 2019-10-09 14:55
 * @since 1.0.0
 */
public enum SingletonByEnum {
    INSTANCE;

    private SingletonByEnum() {
    }

    public static SingletonByEnum getInstance() {
        return INSTANCE;
    }
}
