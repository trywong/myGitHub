package com.test.jdk8.methodreference;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world");
        // 普通lambda实现方式
        list.forEach(item -> System.out.println(item));

        // 方法引用的实现方式(和上面那种方式实现的效果是一样的)
        // ::后面的那个是::前面的那个对象里的一个方法
        // 这里的"System.out::println"是一个方法引用，可以看做是它是指向另外一个函数的这么一个指针，指向哪个函数呢？就是上面那个lambda里面的那个“System.out.println(item)”。
        list.forEach(System.out::println);
    }
}
