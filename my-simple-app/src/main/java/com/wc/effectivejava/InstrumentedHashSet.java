package com.wc.effectivejava;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {
    // set自创建，曾经加入元素个数
    private int addCount = 0;

    public InstrumentedHashSet() {

    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
    
    public static void main(String[] args) {
        InstrumentedHashSet<String> set = new InstrumentedHashSet<String>();
        set.addAll(Arrays.asList("aa", "bb", "cc"));
        System.out.println(set.getAddCount());
    }
}
