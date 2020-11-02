package com.wc.algorithm.beauty;

/**
 * 数组实现的队列---顺序队列
 *
 * @author shovel
 * @date 2018/11/26 16:12
 * @since 1.0.0
 */
public class ArrayQueue {
    private int[] array;
    private int capacity;
    private int head;
    private int tail;

    public ArrayQueue(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
        head = 0;
        tail = 0;
    }

    public boolean enqueue(int element) {
        // 队列满了
        if (tail == capacity) {
            // 队列被元素全部填满
            if (head == 0) {
                return false;
            }

            //移动head~tail之间的元素到0~(tail-head)
            for (int i = head; i < tail; i++) {
                array[i - head] = array[i];
            }

            tail = tail - head;
            head = 0;
        }

        array[tail] = element;
        ++tail;

        return true;
    }

    public Integer dequeue() {
        // 队列空了
        if (head == tail) {
            return null;
        }

        int result = array[head];
        ++head;

        return result;
    }
}
