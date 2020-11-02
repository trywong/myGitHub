package com.wc.effectivejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class FieldAndMethod {
    static Integer val;

    private static final AtomicLong atomic = new AtomicLong();

    public static void main(String[] args) {

    }

    private static void nanoTime() {
        long startTime = System.nanoTime();
        // ... the code being measured ...
        // Thread.sleep(2);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(estimatedTime);
    }

    private static void arrayAndList() {
        String[] array = new String[] { "aaa", "bbb", "ccc" };
        List<String> list = new ArrayList();
        list.add("xxx");
        list.add("yyy");
        list.add("zzz");
        List<String> listFromArray = Arrays.asList(array);
        
        String[] arrayFromList = new String[list.size()];
        list.toArray(arrayFromList);
        System.out.println(Arrays.toString(arrayFromList));
    }

    private static void stringValueOf() {
        char[] c = new char[] { 'a', 'b', 'c' };
        Object o = c;
        String str = String.valueOf(c);
        String str1 = String.valueOf(o);
        System.out.println(str);//abc
        System.out.println(str1);// [C@4eb09321
    }

    private static void newAndValueOf() {
        int aa = 123;
        int bb = 123;
        Integer valueOfA = Integer.valueOf(aa);
        Integer valueOfB = Integer.valueOf(bb);
        Integer valOfB = new Integer(bb);
        System.out.println(valueOfA == valueOfB);   // true
        System.out.println(valueOfA == valOfB);     // false
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    /**
     * -128~127间的Integer值，会事先初始化缓存起来
     * <详细描述>
     * @Throws 异常信息
     * @History 2017年3月14日 by wangchuan
     */
    private static void numberCache() {
        Integer i = 123;
        Integer j = 123;
        System.out.println(i == j);         // true
        System.out.println(i.equals(j));    // true

        Integer a = 1234;
        Integer b = 1234;
        System.out.println(a == b);         // false
        System.out.println(a.equals(b));    // true

        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y);
        System.out.println(x.equals(y));

        String s = new String("abc");
        String q = new String("abc");
        System.out.println(s == q);         // false
        System.out.println(s.equals(q));    // true

        Integer intVal = 112;
        Integer numberVal = 112;
        Box<Integer> aa = new Box<Integer>(intVal);
        Box<Number> bb = new Box<Number>();
        bb.setData(numberVal);
        System.out.println(aa.getData() == bb.getData());  // true
    }

    public static long generateNumber() {
        return atomic.getAndIncrement();
    }

    /**
     * effectiveJava 第5章 优先考虑使用泛型
     * @History 2016年12月14日 下午2:42:50 by wangchuan
     */
    private static void genericType() {
        List<Integer> list = newArrayList();
        list.add(1);
        list.add(3);
        list.add(2);
        Integer result = reduce(list, new Function<Integer>() {
            @Override
            public Integer apply(Integer obj1, Integer obj2) {
                return obj1 + obj2;
            }
        }, 5);
        System.out.println(result);

        List<String> strList = newArrayList();
        strList.add("aa");
        strList.add("bb");
        strList.add("cc");
        String strResult = reduce(strList, new Function<String>() {
            @Override
            public String apply(String obj1, String obj2) {
                return obj1 + obj2;
            }
        }, "dd");
        System.out.println(strResult);

        /*
         * 类型参数出现在变量声明的两边，显得有些冗余
         * 
         */
        Map<String, Object> map = newHashMap();
    }

    static <E> E reduce(List<E> list, Function<E> f, E e) {
        // 1, 3, 2
        // E[] array = (E[]) list.toArray();
        List<E> copyList;
        synchronized (list) {
            copyList = new ArrayList<E>(list);
        }
        // 6
        E obj = e;
        for (E ele : copyList) {
            obj = f.apply(obj, ele);
        }
        return obj;
    }

    /*
     * 泛型静态工厂方法
     */
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<E>();
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<K, V>();
    }
}

class Box<T> {

    private T data;

    public Box() {

    }

    public Box(T data) {
        setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
