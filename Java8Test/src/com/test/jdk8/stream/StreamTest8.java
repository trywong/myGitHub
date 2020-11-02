package com.test.jdk8.stream;

import java.util.stream.IntStream;

public class StreamTest8 {
    public static void main(String[] args) {
        // distinct()他不知道只有0和1，它会一直等待程序一直执行等着看有没有新的元素产生，相当于是搞了一个无限循环的例子
        IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(6).forEach(System.out::println);
        // 改成下面这个写法就对了
        IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);
    }
}
