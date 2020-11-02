package com.test.jdk8.parallelStream;

import java.util.Arrays;
import java.util.List;

public class StreamTest10 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "worlds", "hello world");

        // 下面这个使我们主要想讲的内容，System.out.println(item);这个会打印出来什么东西呢？这个是重点
        // 结果只有一个hello，并没有world和hello world，为什么呢？
        // 一般的最常见的错误的理解是下面这段代码执行mapToInt，再执行filter，再执行findFirst等以此类推，但是这种理解完全是错误的，前面就讲过，流并不是按照编码的方法先后顺序去挨个执行的，这种理解完全错误。
        // 我们可以把流想象成一个容器，容器里面存放的是对流里面的每一个元素的的操作，比如"length->length==5"等等这些操作，既然存放的是操作，当对流进行处理的话，比如进行迭代、判断、过滤、映射等等操作，它会拿着这些操作把这些所有的操作逐个的应用到流里面的每一个元素上，并且会将这些操作给串行化，就是对一个元素应用完第一个操作之后紧接着应用第二个操作，直到把所有都应用完，然后再去循环第二个元素，这时也是会把所有的动作都应用在它身上。而不是说对一个元素应用完第一个操作，紧接着对第二个元素应用第一个操作，不是这样的。
        // 对一个元素应用完第一个操作之后紧接着应用第二个操作，直到把所有都应用完，然后再去循环第二个元素，这时也是会把所有的动作都应用在它身上。这里面还有一个短路的说法，这里面有一个findFirst()的操作是要找到第一个元素，这里面就是hello，而且它的长度正好是5，类似于Java里的且与或的短路，所以它拿出来hello之后进过一系列的运算发现它就符合最终的要求了，所以后面的元素根本就不会再去任何的执行和计算了。直接把5就打出来了。
        // 如果把集合里的hello改成hello1，那么下面这个最后打印出来的就是hello1、world、5，因为程序在第一次拿出hello1做一系列逻辑判断之后发现它不符合要求，那么程序就会循环第二个元素拿出world进行一系列的逻辑判断，判断之后发现world复合条件要求，那么就不会再循环后面的元素了
        list.stream().mapToInt(item -> {
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(length -> length == 6).findFirst().ifPresent(System.out::println);
    }
}
