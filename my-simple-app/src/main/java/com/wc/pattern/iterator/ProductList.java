package com.wc.pattern.iterator;

import java.util.List;

/**
 * 具体聚合类
 * @author shovel
 * @date 2018/10/15 11:12
 * @since 1.0.0
 */
public class ProductList extends AbstractObjectList {
    public ProductList(List products) {
        super(products);
    }

    @Override
    public AbstractIterator createIterator() {
        return new ProductIterator();
    }

    /**
     * 具体迭代器类
     * @author shovel
     * @date 2018/10/15 11:09
     * @since 1.0.0
     */
    private class ProductIterator implements AbstractIterator {
        private int cursor1; //定义一个游标，用于记录正向遍历的位置
        private int cursor2; //定义一个游标，用于记录逆向遍历的位置

        public ProductIterator() {
            cursor1 = 0; //设置正向遍历游标的初始值
            cursor2 = objects.size() -1; //设置逆向遍历游标的初始值
        }

        @Override
        public void next() {
            if(cursor1 < objects.size()) {
                cursor1++;
            }
        }

        @Override
        public boolean isLast() {
            return (cursor1 == objects.size());
        }

        @Override
        public void previous() {
            if (cursor2 > -1) {
                cursor2--;
            }
        }

        @Override
        public boolean isFirst() {
            return (cursor2 == -1);
        }

        @Override
        public Object getNextItem() {
            return objects.get(cursor1);
        }

        @Override
        public Object getPreviousItem() {
            return objects.get(cursor2);
        }
    }
}
