package com.iterators.business.feign.fallback;

import com.iterators.business.feign.OrderRemoteClient;
import org.springframework.stereotype.Component;

/**
 * 添加类描述信息
 *
 * @author zhanghui
 * @date 2020/9/22 8:26 下午
 */
@Component
public class OrderHystrixClientFallback extends AbstractHystrixClientFallback<OrderRemoteClient> {
    @Override
    public OrderRemoteClient createDefaultMsg() {
        return () -> "order default";
    }
}
