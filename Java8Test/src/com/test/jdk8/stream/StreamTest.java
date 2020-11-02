package com.test.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        // 流的常用创建方式有三种：
        Stream stream1 = Stream.of("hello", "world", "hello world");

        String[] myArray = new String[] { "hello", "world", "hello world" };
        Stream stream2 = Stream.of(myArray);
        Stream stream3 = Arrays.stream(myArray);
        List<String> list = Arrays.asList(myArray);
        Stream stream4 = list.stream();
    }
}
