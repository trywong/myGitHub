package com.test.jdk8.parallelStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest12 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        // 需求：分组分别上下两个一组组打印出来，比如"Hi zhangsan"、"Hi list"、"Hello zhangsan"......
        // 这里面必须用flatMap，否则会报错，如果这里外边那层的flatMap替换成map的话，这个map返回的结果就是Stream<Stream<String>>，而不是一个字符串流，因为外边那层新返回的那个大的流里面的元素没有打平
        List<String> result = list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
