package com.wc.effectivejava;

import java.util.Arrays;

public class MyStack {
    private static final int CAPACITY = 16;

    private Object[] elements;

    private int size = 0;

    public MyStack() {
        elements = new Object[CAPACITY];
    }

    public void push(Object ele) {
        ensureCapacity();
        elements[size++] = ele;
    }

    public Object pop() {
        if (size == 0) {
            throw new UnsupportedOperationException("no element...");
        }
        Object object = elements[--size];
        // 此处一定要回收！！！垃圾回收器不会主动回收这种过期引用！
        elements[size] = null;
        return object;
    }

    public void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(new Person.Builder("1234", "张三1").gender(0).weight(61f).build());
        stack.push(new Person.Builder("2345", "张三2").gender(1).weight(62f).build());
        stack.push(new Person.Builder("3456", "张三3").gender(1).weight(63f).build());
        stack.push(new Person.Builder("4567", "张三4").gender(0).weight(64f).build());
        stack.push(new Person.Builder("5678", "张三5").gender(1).weight(65f).build());
        stack.push(new Person.Builder("6789", "张三6").gender(0).weight(66f).build());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
