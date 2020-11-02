package com.test.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        TheInterface i1 = () -> {
        };
        System.out.println(i1.getClass().getInterfaces()[0]);

        TheInterface2 i2 = () -> {
        };
        System.out.println(i2.getClass().getInterfaces()[0]);
        // lambda到底是一个什么类型的，一定是由上下文才能断定的，例如，如下代码，编译器是不知道它是什么类型的
        // () -> {};
        /*new Thread(() -> {
            System.out.println("hello world");
        });*/
        // new Thread(() -> System.out.println("hello world"));

        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.forEach(item -> System.out.println(item.toUpperCase()));
        // 新需求来了，把list里面的每一个元素的首字母变成大写并放到一个新的集合里，然后打印出来
        List<String> list2 = new ArrayList<>();// diamond，菱形语法。从jdk8开始这里不需要指定类型了，编译器会有类型推断，编译器会自动推断出里面是什么类型
        list.forEach(item -> list2.add(item.toUpperCase()));
        list2.forEach(item -> System.out.println(item));
        // 其实，实现这个新的需求有更简单的方式，即：流stream的方式。后面会详细介绍这种方式
        // 流有串行流和并行流两种。另外一个围度的区分还有：中间流和节点流两种
        // stream()方法是返回一个将当前的集合当做源的一个串行流。stream这个东西本身和linux里面的管道非常类似。这里面的map方法标识映射的意思，把每一个元素映射成它的首字母大写，map方法返回的也是一个stream流，再调用stream方法的forEach()方法，stream里面的forEach()方法和list里面的forEach()方法作用是一样的。
        // 关于流这块的东西后面会专门介绍的，这里不用太纠结
        // Lambda构建
        list.stream().map(item -> item.toUpperCase()).forEach(item -> System.out.println(item));
        // 下面通过方法引用构建lambda表达式函数式接口的实例来改造上面的代码【方法引用构建】
        list.stream().map(String::toUpperCase).forEach(item -> System.out.println(item));
    }
}

@FunctionalInterface
interface TheInterface {
    void myMethod();
}

@FunctionalInterface
interface TheInterface2 {
    void myMethod2();
}