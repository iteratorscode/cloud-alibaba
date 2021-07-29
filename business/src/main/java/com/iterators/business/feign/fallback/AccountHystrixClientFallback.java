package com.iterators.business.feign.fallback;

import com.iterators.business.feign.AccountRemoteClient;
import org.springframework.stereotype.Component;

/**
 * 添加类描述信息
 *
 * @author zhanghui
 * @date 2020/9/22 8:39 下午
 */
@Component
public class AccountHystrixClientFallback<T> extends AbstractHystrixClientFallback<AccountRemoteClient> {
    @Override
    public AccountRemoteClient createDefaultMsg() {
        return () -> "account default";
    }
}
