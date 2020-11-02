package com.wc.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 5, 3, 4);
        list.stream().map(n -> n * n).collect(Collectors.toList()).forEach(System.out::println);
    }
}
