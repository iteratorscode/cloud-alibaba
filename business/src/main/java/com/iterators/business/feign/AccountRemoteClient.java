package com.iterators.business.feign;

import com.iterators.business.feign.fallback.AccountHystrixClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 账户服务
 *
 * @author iterators
 * @date 2020/9/16 8:23 下午
 */
@FeignClient(value = "ACCOUNT", path = "/account", fallbackFactory = AccountHystrixClientFallback.class)
public interface AccountRemoteClient {

    @PostMapping("/deduction")
    String deduction();
}
