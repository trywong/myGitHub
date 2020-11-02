package com.test.jdk8.optional;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");
        // optional = Optional.empty();
        // 判断optional里面的那个值是否存在，存在的话就直接打印出来
        // 编译器是建议调用Optional的get()方法获取容器里面值对象的时候，一定要先调用isPresent()方法进行判断这个值是否存在。如果不这么用而直接调用get()方法的话编译器会发出警告。
        // 如果编译器不包含这个对象的话，不判断直接调用get()方法会抛异常
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
        // 但其实返回来说，上面那种写法和我们日常经常写的null为空判断的写法其实是没多大区别的，其实本质上根本没区别。以上的写法是不被推荐的
        // Optional的推荐的使用方式如下：
        optional.ifPresent(item -> System.out.println(item));// 推荐的Optional使用方式
        // 上面的使用方式里面，在ifPresent首先会检查optional容器里面的value值是否为null，为null的话什么也不做，不为null的话才操作参数里面传进去的动作

        System.out.println("==========================");
        // 如果optional容器里面的value有值，就打印出来值，如果没有的话就打印出来一个备选的值world
        System.out.println(optional.orElse("world"));
        System.out.println("==========================");
        // 接受的是一个Supplier的函数式接口(不接收参数，返回一个值)，如果容器里面的值为空的话就要用supplier这个函数式接口获取到一个值打出来，不为空的话就打印容器里面的那个值
        System.out.println(optional.orElseGet(() -> "nihao"));
        System.out.println("==========================");
        // 具体什么时候使用ofNullable，什么时候使用of，视实际情况而定，如果比如你调用第三方拿到的一个数据，这个数据可能为空也可能不为空，那就用ofNullable。如果有一个数据你百分百确定不为空，那么你就用of就行了
        String a = "......";
        Optional.ofNullable(a);
        Optional.of(a);

    }
}
