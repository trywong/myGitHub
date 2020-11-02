package com.wc.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象聚合类
 * @author shovel
 * @date 2018/10/15 11:11
 * @since 1.0.0
 */
public abstract class AbstractObjectList {
    protected List<Object> objects = new ArrayList<Object>();

    public AbstractObjectList(List objects) {
        this.objects = objects;
    }

    public void addObject(Object obj) {
        this.objects.add(obj);
    }

    public void removeObject(Object obj) {
        this.objects.remove(obj);
    }

    public List getObjects() {
        return this.objects;
    }

    //声明创建迭代器对象的抽象工厂方法
    public abstract AbstractIterator createIterator();
}
