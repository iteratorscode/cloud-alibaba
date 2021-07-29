package com.iterators.storage.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品 Controller
 *
 * @author zhanghui
 * @date 2020/9/16 8:24 下午
 */
@RestController
@RequestMapping("/storage")
@Slf4j
public class ProductController {

    @PostMapping("/product")
    @SentinelResource("product")
    public String product() {
        log.info("product");
        return "product";
    }
}
