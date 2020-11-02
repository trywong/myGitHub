package com.wc.app.my_simple_app;

import java.util.ArrayList;
import java.util.List;

public class ChildClass extends ParentClass {
    public static void hahah() {
        staticMethod();
    }

    /*public static void staticMethod() {
        System.out.println("in child");
    }*/

    public static void main(String[] args) {
        List<Long> list = new ArrayList<Long>();
        list.add(1l);
        list.add(2l);
        list.add(3l);
        List<Long> list2 = new ArrayList<Long>();
        list2.add(2l);
        list2.add(4l);
        
        list.removeAll(list2);
        for (Long a : list) {
            System.out.println(a);
        }
    }
}
