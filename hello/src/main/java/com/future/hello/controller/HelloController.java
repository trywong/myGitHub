package com.future.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shovel
 * @date 2018/12/4 16:27
 * @since 1.0.0
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello, Shovel";
    }
}
