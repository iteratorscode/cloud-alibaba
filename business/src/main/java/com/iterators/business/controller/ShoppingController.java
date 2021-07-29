package com.iterators.business.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.iterators.business.service.ShoppingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * 购物 Controller
 *
 * @author zhanghui
 * @date 2020/9/16 8:12 下午
 */
@RestController
@RequestMapping("/shopping")
@AllArgsConstructor
public class ShoppingController {

    private final ShoppingService shoppingService;

    @GetMapping("/order1")
    public String order1() throws ExecutionException, InterruptedException {
        return shoppingService.order();
    }

    @GetMapping("/order2")
    public String order2() throws ExecutionException, InterruptedException {
        return shoppingService.order();
    }
}
