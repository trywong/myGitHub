package com.wc.pattern.singleton;

/**
 * @author wangchuan
 * @date 2019-10-09 14:45
 * @since 1.0.0
 */
public class SingletonTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingletonByEnum instance = SingletonByEnum.getInstance();
                    System.out.println(instance.hashCode());
                }
            }).start();
        }
    }
}
