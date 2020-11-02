package com.wc.algorithm;

/**
 *
 * 实现栈功能：push pop top getMin
 *
 * 要求时间复杂度为o(1)
 *
 * @author wangchuan
 * @date 2020-09-25 17:51
 * @since 1.0.0
 */
public class MyStack {
    java.util.Stack<Integer> dataStack = new java.util.Stack<>();
    java.util.Stack<Integer> minStack = new java.util.Stack<>();

    public Integer push(Integer item) {
        if (minStack.isEmpty()) {
            minStack.push(item);
        } else {
            Integer peek = minStack.peek();
            if (item < peek) {
                minStack.push(item);
            } else {
                minStack.push(peek);
            }
        }
        return dataStack.push(item);
    }

    public Integer pop() {
        minStack.pop();
        return dataStack.pop();
    }

    public Integer top() {
        return dataStack.peek();
    }

    public Integer getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        System.out.println("min:" + myStack.getMin());

        myStack.push(-10);
        System.out.println("min:" + myStack.getMin());

        myStack.push(5);
        System.out.println("min:" + myStack.getMin());

        myStack.push(-100);
        System.out.println("min:" + myStack.getMin());

    }
}

