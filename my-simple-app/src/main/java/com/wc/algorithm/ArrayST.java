package com.wc.algorithm;

/**
 * 无序数组
 * @author wangchuan
 * @since
 */
public class ArrayST<Key, Value> {
    Key[] keys;
    Value[] values;

    int size;

    public ArrayST(int capacity) {
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
    }

    public Value get(Key key) {
        int index = findIndex(key);
        if (index == -1 || index >= size) {
            return null;
        }

        return values[index];
    }

    public void put(Key key, Value value) {
        int index = findIndex(key);
        if (index != -1) {// 命中
            values[index] = value;
            return;
        }

        // 未命中，创建元素
        size++;
        keys[size - 1] = key;
        values[size - 1] = value;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append(keys[i] + ":" + values[i] + "\n");
        }
        return sb.toString();
    }

    int findIndex(Key key) {
        for (int i = 0; i < size; i++) {
            if (key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String[] word = new String[] { "A+", "A", "A+", "B+", "B-", "B-", "C+", "C", "C-", "D", "F" };
        Float[] score = new Float[] { 4.33F, 4.00F, 3.67F, 3.33F, 3.00F, 2.67F, 2.33F, 2.00F, 1.67F, 1.00F, 0F };
        ArrayST st = new ArrayST(20);
        for (int i = 0; i < word.length; i++) {
            st.put(word[i], score[i]);
        }

        System.out.println(st.toString());
    }
}
