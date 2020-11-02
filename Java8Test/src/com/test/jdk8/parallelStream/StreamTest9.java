package com.test.jdk8.parallelStream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class StreamTest9 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; i++) {
            list.add(UUID.randomUUID().toString());
        }
        System.out.println("开始排序");
        long startTime = System.nanoTime();
        // 这里执行count()是因为sorted()是一个中间操作，count()是一个终止操作，是为了有一个终止操作可执行
        // 这里是用串行流执行的
        list.stream().sorted().count();
        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("串行流排序耗时：" + millis);
        System.out.println("===================================");
        // 下面用并行流执行
        list.parallelStream().sorted().count();
        long endTime2 = System.nanoTime();
        long millis2 = TimeUnit.NANOSECONDS.toMillis(endTime2 - endTime);
        System.out.println("并行流排序耗时：" + millis2);
    }
}
