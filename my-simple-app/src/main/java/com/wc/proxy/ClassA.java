package com.wc.proxy;

public class ClassA implements ExInterface {

    @Override
    public void firstMethod() {
        System.out.println("执行ClassA的firstMethod方法");
    }

    @Override
    public int secondMethod(int a, int b) {
        System.out.println("执行ClassA的secondMethod方法");
        return a + b;
    }

    @Override
    public void superMethod() {
        System.out.println("执行ClassA的superMethod方法");
    }
}
