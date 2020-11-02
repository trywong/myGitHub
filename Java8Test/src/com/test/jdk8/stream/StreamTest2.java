package com.test.jdk8.stream;

import java.util.stream.IntStream;

public class StreamTest2 {
    public static void main(String[] args) {
        // 首先构建一个以5,6,7这个数组为源的一个Stream，然后调用这个流的forEach方法，紧接着把它打印出来
        IntStream.of(new int[] { 5, 6, 7 }).forEach(System.out::println);
        System.out.println("=============");
        // 构建一个以3开头以8结尾，但是不包含8的这么一个IntStream，然后把它们循环打印出来
        IntStream.range(3, 8).forEach(System.out::println);
        System.out.println("=============");
        IntStream.rangeClosed(3, 8).forEach(System.out::println);
    }
}
