package com.iterators.business.feign;

import com.iterators.business.feign.fallback.StorageHystrixClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 仓储服务
 *
 * @author iterators
 * @date 2020/9/16 8:22 下午
 */
@FeignClient(value = "STORAGE", path = "/storage", fallbackFactory = StorageHystrixClientFallback.class)
public interface StorageRemoteClient {

    @PostMapping("/product")
    String product();
}
