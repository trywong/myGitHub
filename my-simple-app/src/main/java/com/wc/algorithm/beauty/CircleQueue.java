package com.wc.algorithm.beauty;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 循环队列
 *
 * @author shovel
 * @date 2018/11/26 18:01
 * @since 1.0.0
 */
public class CircleQueue {
    private int[] array;
    private int capacity;
    private int head = 0;
    private int tail = 0;

    public CircleQueue(int capacity) {
        array = new int[capacity];
    }

    /**
     * 入队
     *
     * @param element
     */
    public void enqueue(int element) {
        // 队列满了
        if ((tail + 1) % capacity == head) {
            return;
        }

        array[tail] = element;
        tail = (tail + 1) % capacity;
    }

    public Integer dequeue() {
        // 队列空
        if (head == tail) {
            return null;
        }

        int item = array[head];
        head = (head + 1) % capacity;
        return item;
    }

    public static void main(String[] args) {
        Map map = new HashMap<String, String>();
        map.put(null, "123");

        map = new Hashtable();
        map.put("444", null);

        System.out.println(map.get("444"));
    }
}
