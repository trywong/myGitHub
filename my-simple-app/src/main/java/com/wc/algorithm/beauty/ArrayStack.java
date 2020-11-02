package com.wc.algorithm.beauty;

/**
 * 数组实现栈
 *
 * @author shovel
 * @date 2018/11/26 10:37
 * @since 1.0.0
 */
public class ArrayStack {
    private int[] array;
    private int capacity;
    private int n;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        n = 0;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        for (int i = 10; i <= 100; i += 10) {
            stack.pushByDynamicSize(i);
        }

        for (int i = 0; i < stack.capacity; i++) {
            System.out.println(stack.pop());
        }
    }

    public boolean push(int element) {
        // 栈满了
        if (n == capacity) {
            return false;
        }

        array[n] = element;
        ++n;
        return true;
    }

    /**
     * 动态扩容入栈
     *
     * @param element
     *
     * @return
     */
    public boolean pushByDynamicSize(int element) {
        // 栈满了
        if (n == capacity) {
            // 扩容为原来数组两倍
            int[] newArray = new int[capacity * 2];
            for (int i = 0; i < capacity; i++) {
                newArray[i] = array[i];
            }
            capacity = capacity * 2;
            array = newArray;
        }

        array[n] = element;
        ++n;
        return true;
    }

    public Integer pop() {
        // 栈为空
        if (n == 0) {
            return null;
        }

        int ret = array[n - 1];
        --n;
        return ret;
    }
}
