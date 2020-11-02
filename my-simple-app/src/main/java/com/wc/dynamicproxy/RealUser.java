package com.wc.dynamicproxy;

/**
 * @author shovel
 * @date 2018/12/5 17:26
 * @since 1.0.0
 */
public class RealUser implements IUser {
    @Override
    public void coding(String language) {
        System.out.println("编程语言：" + language);
    }

    @Override
    public void rest() {
        System.out.println("休息中");
    }
}
