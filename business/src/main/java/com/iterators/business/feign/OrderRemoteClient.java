package com.iterators.business.feign;

import com.iterators.business.feign.fallback.OrderHystrixClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 订单远程服务
 *
 * @author iterators
 * @date 2020/9/15 8:27 下午
 */
@FeignClient(name = "ORDER", path = "/order", fallbackFactory = OrderHystrixClientFallback.class)
public interface OrderRemoteClient {

    @PostMapping("/create")
    String create();
}
