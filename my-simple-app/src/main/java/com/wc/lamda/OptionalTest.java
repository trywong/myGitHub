package com.wc.lamda;

import java.util.Optional;

/**
 * @author wangchuan
 * @date 2019-04-04 14:09
 * @since 1.0.0
 */
public class OptionalTest {
    public static void main(String[] args) {
        System.out.println(lowerCase(null));
    }

    public static String lowerCase(String string) {
        return Optional.ofNullable(string).map(item -> item.toLowerCase()).orElse("unkown");
    }
}
