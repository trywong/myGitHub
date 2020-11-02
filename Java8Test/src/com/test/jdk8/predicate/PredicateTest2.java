package com.test.jdk8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        PredicateTest2 predicateTest2 = new PredicateTest2();
        // 第一个需求，找出里面所有的奇数
        predicateTest2.conditionFilter(list, item -> item % 2 == 0);
        System.out.println("========================");
        // 第二个需求，找出里面所有的偶数
        predicateTest2.conditionFilter(list, item -> item % 2 != 0);
        System.out.println("========================");
        // 第三个需求，找出里面所有大于5的数字
        predicateTest2.conditionFilter(list, item -> item > 5);
        System.out.println("========================");
        // 打印出来所有的元素
        predicateTest2.conditionFilter(list, item -> true);
        // 所有的元素都不打印
        predicateTest2.conditionFilter(list, item -> false);
        // 归根结底我们要理解函数式接口的编程方式给我们带来了什么？
        System.out.println("========================");
        // 需求：要求找出当前这个集合里面大于5并且都是偶数的数字
        predicateTest2.conditionFilter2(list, item -> item > 5, item -> item % 2 == 0);
        System.out.println("========================");
    }

    // 具体的过滤动作predicate是外部调用的时候传递进来的
    // 函数式编程提供了更高层次的一种抽象化
    // predicate的test方法的实现是调用者在调用的时候传递进来的
    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer integer : list) {
            if (predicate.test(integer)) {
                System.out.println(integer);
            }
        }
    }

    // and操作
    public void conditionFilter2(List<Integer> list, Predicate<Integer> predicate, Predicate<Integer> predicate2) {
        for (Integer integer : list) {
            if (predicate.and(predicate2).test(integer)) {
                System.out.println(integer);
            }
        }
    }

    // or操作
    public void conditionFilter3(List<Integer> list, Predicate<Integer> predicate, Predicate<Integer> predicate2) {
        for (Integer integer : list) {
            if (predicate.or(predicate2).test(integer)) {
                System.out.println(integer);
            }
        }
    }

    // and + negate(先and，之后取反)
    public void conditionFilter4(List<Integer> list, Predicate<Integer> predicate, Predicate<Integer> predicate2) {
        for (Integer integer : list) {
            if (predicate.and(predicate2).negate().test(integer)) {
                System.out.println(integer);
            }
        }
    }
}
