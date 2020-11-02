package com.wc.algorithm;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 有序数组
 * @author wangchuan
 * @since
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;

    private int size;

    public BinarySearchST(int capacity) {
        // 调整数组大小的标准代码请见算法1.1
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public Value get(Key key) {
        if (isEmpty())
            return null;
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0)
            return vals[i];
        else return null;
    }

    /**
     * 找出小于指定键的键的数量
     * BinarySearchST.rank()
     * @Author wangchuan
     * @Date 2018年1月23日
     * @since
     * @param key
     * @return
     */
    public int rank(Key key) {
        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0)
                hi = mid - 1;
            else if (cmp > 0)
                lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void put(Key key, Value val) {
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {// 查找键， 找到则更新值
            vals[i] = val;
            return;
        }

        /*
         * 移动插入位置之后的所有元素
         */
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        /*
         * 创建新的元素
         */
        keys[i] = key;
        vals[i] = val;
        size++;
    }

    public int rank1(Key key, int lo, int hi) {
        if (lo > hi) {
            return lo;
        }

        int mid = (lo + hi) / 2;
        if (key.compareTo(keys[mid]) < 0) {
            rank1(key, lo, mid - 1);
        } else if (key.compareTo(keys[mid]) > 0) {
            rank1(key, mid + 1, hi);
        }
        return mid;
    }

    public void delete(Key key) {
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            if (i == size - 1) {// 最后一个元素
                keys[size - 1] = null;
                vals[size - 1] = null;
            } else {
                for (int j = i; j < size; j++) {
                    keys[j] = keys[j + 1];
                    vals[j] = vals[j + 1];
                }
            }

            size--;
        }
    }

    /**
     * 命中：key本身
     * 未命中：小于key的最大值
     * BinarySearchST.ceiling()
     * @Author wangchuan
     * @Date 2018年1月22日
     * @since
     * @param key
     * @return
     */
    public Key ceiling(Key key) {
        int i = rank1(key, 0, size - 1);
        return keys[i];
    }

    /**
     * ....未验证
     * BinarySearchST.floor()
     * @Author wangchuan
     * @Date 2018年1月22日
     * @since
     * @param key
     * @return
     */
    public Key floor(Key key) {
        int i = rank1(key, 0, size - 1);
        if (key.equals(keys[i])) {
            return key;
        }
        if (i < size - 1) {
            return keys[i + 1];
        }
        return null;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> qu = new ArrayBlockingQueue<Key>(size);
        for (int i = rank(lo); i < rank(hi); i++) {
            qu.add(keys[i]);
        }
        return qu;
    }

    public boolean isEmpty() {
        return size <= 0;
    }
}
