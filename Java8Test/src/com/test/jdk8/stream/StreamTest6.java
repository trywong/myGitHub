package com.test.jdk8.stream;

import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

public class StreamTest6 {
    public static void main(String[] args) {
        // iterate表示对种子元素(这里的1)循环的使用第二个参数的动作，比如先是1+2=3，然后3+2=5，然后5+2=7，把每次计算出来的结果都放到流里面去，后面的limit是表示这样的动作循环执行几次
        // iterate生成的是一个无限的串行流，所以一般情况下用iterate的时候都会跟着一个limit进行限制
        Stream.iterate(1, item -> item + 2).limit(6).forEach(System.out::println);
        Stream<Integer> stream = Stream.iterate(1, item -> item + 2).limit(6);
        // 需求：找出流中大于2的元素，然后将每个元素乘以2，然后忽略掉流中的前两个元素，然后再取流中的前两个元素，最后求出流中元素的总和
        System.out.println(stream.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).sum());
        // 找出流中最小的那个元素。min()返回的是一个OptionalInt，而sum()返回的却是一个普通的int，取决于一个值可不可能为空，sum()肯定不为空，而min()就有可能为空了，如果流里面没有元素那不就是空了
        stream.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).min().ifPresent(System.out::println);

        // 同时求出最小值、最大值、总和。summaryStatistics()是一个终止操作
        IntSummaryStatistics intSummaryStatistics = stream.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();
        intSummaryStatistics.getAverage();// 平均值
        intSummaryStatistics.getCount();// 总和
        intSummaryStatistics.getMin();// 最小值
        intSummaryStatistics.getMax();// 最大值

    }
}
