package com.test.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest5 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        // 需求：将集合里面的所有字母转换成大写，然后输出
        // 流里面的map表示映射的意思，后面那个collect是把流转换成List(collect()是一个终止操作)
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("==============================");
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        list2.stream().map(item -> item * item).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("==============================");

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        // 先调用flatMap()是为了把里面包含的三个集合打平，打成三个集合的所有元素都在这个Stream的同一级上
        // Stream<Integer>
        stream.map(theList -> theList.stream());
        stream.flatMap(theList -> theList.stream()).map(item -> item * item).forEach(System.out::println);
    }
}
