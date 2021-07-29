package com.iterators.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单 Controller
 *
 * @author zhanghui
 * @date 2020/9/15 8:29 下午
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @PostMapping("/create")
    @SentinelResource("create")
    public String create() {
        log.info("order create ok");
        return "order create ok";
    }
}
