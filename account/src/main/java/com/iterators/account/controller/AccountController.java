package com.iterators.account.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.iterators.account.feign.OrderRemoteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户 Controller
 *
 * @author zhanghui
 * @date 2020/9/15 8:32 下午
 */
@RestController
@AllArgsConstructor
@RequestMapping("/account")
@Slf4j
public class AccountController {

    private final OrderRemoteService orderRemoteService;

    @PostMapping(value = "/order")
    @SentinelResource("order")
    public String order() {
        return orderRemoteService.create();
    }

    @PostMapping("/deduction")
    public String deduction() {
        log.info("deduction");
        return "deduction";
    }
}
