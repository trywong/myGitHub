package com.test.jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest4 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "helloworld");
        // 通过lambda方式实现
        String[] stringArray = stream.toArray(length -> new String[length]);
        Arrays.asList(stringArray).forEach(System.out::println);
        // 通过构造方法引用实现：
        String[] stringArray2 = stream.toArray(String[]::new);

        Stream<String> stream2 = Stream.of("hello", "world", "helloworld");
        // 将流转换成List。这种写法是最简单的写法，但是最难理解，这个是相当于把下面那种复杂的方式封装了。
        List<String> list = stream2.collect(Collectors.toList());
        // 看下最原始的写法，就大概能理解上面那种简单的方式是如何实现的了，下面看下原始的比较复杂的写法
        // 看collect源码会看到collect的含义大概如下：
        // 它接收三个参数(Supplier<R> supplier,BiConsumer<R, ? super T> accumulator,BiConsumer<R, R>
        // combiner);
        // 它对这三个参数执行的操作大概如下这段代码：
        /*<pre>{@code
            R result = supplier.get();
            for (T element : this stream)
                accumulator.accept(result, element);
            return result;
        }</pre>*/
        // 第一个参数是构造一个空的集合(最后返回的也是这里构造出来的这个对象)；第二个参数的动作是遍历流里面的每一个元素，然后把每一个遍历到的元素item添加到集合theList中，大概就是这么一个动作；第三个参数里面的theList1也就是第一个参数返回的那个集合(就是最终要返回的那个集合对象)，第三个参数里的theList2其实就是第二个参数里面的集合，第三个参数的动作是说将第二个参数(中间生成的那些List)里面的那个集合整个加到第一个参数的那个集合里当结果返回
        // 具体这里面的add方法或addAll方法是谁来调的，是在运行的时候由jdk处理器根据collect方法签名动态的生成这个对象并且传递进去这些动作去执行。
        // collect()方法是一个终止操作方法
        List<String> list2 = stream2.collect(() -> new ArrayList(), (theList, item) -> theList.add(item),
                                             (theList1, theList2) -> theList1.addAll(theList2));
        // 下面用方法引用实现：
        List<String> list3 = stream2.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        list.forEach(System.out::println);

        // 一种新的方式将Stream转换成List，一种比较通用的方法
        Stream<String> stream3 = Stream.of("hello", "world", "hello world");
        List<String> list4 = stream3.collect(Collectors.toCollection(ArrayList::new));
        list4.forEach(System.out::println);

        // 将Stream转换成Set
        Set<String> set = stream3.collect(Collectors.toCollection(HashSet::new));
        set.forEach(System.out::println);

    }
}
