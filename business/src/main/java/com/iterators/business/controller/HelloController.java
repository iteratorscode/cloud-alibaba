package com.iterators.business.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello Controller
 *
 * @author iterators
 * @date 2021/7/22 3:47 下午
 */
@RestController
@RequestMapping("/hi")
public class HelloController {

    @GetMapping("/hello")
    @SentinelResource("hello")
    public String hello() {
        return "Hi, from iterators";
    }
}
