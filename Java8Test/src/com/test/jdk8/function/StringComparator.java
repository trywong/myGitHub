package com.test.jdk8.function;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringComparator {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(names);

        // 经过lambda表达式简化之后的代码
        /*Collections.sort(names, (String o1, String o2) -> {
            return o2.compareTo(o1);
        });
        System.out.println(names);*/
        // 更简化的代码

        // expression 表达式风�?
        Collections.sort(names, (o1, o2) -> o2.compareTo(o1));

        // statement 风格

        Collections.sort(names, (o1, o2) -> {
            return o2.compareTo(o1);
        });
    }
}
