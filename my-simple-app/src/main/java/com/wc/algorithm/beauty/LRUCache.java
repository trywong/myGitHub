package com.wc.algorithm.beauty;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author shovel
 * @date 2018/12/20 11:40
 * @since 1.0.0
 */
public class LRUCache {
    LRU cache;

    public LRUCache(int capacity) {
        cache = new LRU(capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public void print() {
        if (cache != null) {
            cache.forEach((key, value) -> {
                System.out.println(value);
            });
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.put(5, 5);
        cache.put(6, 6);

        int val1 = cache.get(4);
        int val2 = cache.get(2);
        cache.print();
    }
}

class LRU extends LinkedHashMap<Integer, Integer> {
    int capacity;

    public LRU(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    protected boolean removeEldestEntry() {
        return this.removeEldestEntry();
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > capacity;
    }
}
