package com.test.jdk8.parallelStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest11 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello welcome", "hello world", "hello world hello", "hello welcome");

        // 找出集合中所有的单词，而且要去重
        // 下面这种写法是错误的，为什么是错的呢？
        // 错误原因：这里的map方法应用是错误的，经过这里的这个map映射之后新的流里面的每个元素就变成了字符串数组了，之后去重相当于是对这些数组去重
        list.stream().map(item -> item.split(" ")).distinct().collect(Collectors.toList()).forEach(System.out::println);

        // 下面是正确的写法。使用flatMap把流里面的字符串数组打平，把所有的字符串数组里面的字符串都打到这个流里面去，让其变成一个大的字符串流
        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);
    }
}
