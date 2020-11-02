package com.test.jdk8.lambda;

import java.util.Arrays;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("=====================================");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        // Consumer(消费者)接口里面的accept方法注释为：对于给定的参数t执行这个动作。
        /*list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });*/
        System.out.println("===============================================");
        // 经过Lambda简化之后的代码
        list.forEach((Integer i) -> {
            System.out.println(i);
        });
        // 下面是通过方法引用来创建Lambda的实例(函数式接口的一个实例)（创建Lambda实例的一种方式）。这个后面会专门介绍

        list.forEach(System.out::println);
    }
}
