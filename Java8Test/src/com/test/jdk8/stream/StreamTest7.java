package com.test.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest7 {
    public static void main(String[] args) {
        // 下面主要演示中间操作和终止操作的本质区别
        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.stream().map(item -> item.substring(0, 1).toUpperCase() + item.substring(1)).forEach(System.out::println);
        System.out.println("============================");
        // 执行下面这个代码不会有任何信息打印出来，因为这里所有的操作都是中间操作，没有终止操作，所以这些操作实际都不会被执行
        list.stream().map(item -> {
            String result = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println("test");
            return result;
        });
        System.out.println("============================");
        // 执行下面这段代码会打印出东西来，下面的forEach操作是终止操作，遇到这个终止操作之后前面的所有的中间操作都会被执行
        list.stream().map(item -> {
            String result = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println("test");
            return result;
        }).forEach(System.out::println);
    }
}
