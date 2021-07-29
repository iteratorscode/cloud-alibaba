package com.iterators.account.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 订单远程服务
 *
 * @author zhanghui
 * @date 2020/9/15 8:27 下午
 */
@FeignClient(name = "ORDER", path = "/order")
public interface OrderRemoteService {

    @PostMapping("/create")
    String create();
}
