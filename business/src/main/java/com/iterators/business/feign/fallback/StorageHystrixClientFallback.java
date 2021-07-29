package com.iterators.business.feign.fallback;

import com.iterators.business.feign.StorageRemoteClient;
import org.springframework.stereotype.Component;

/**
 * 添加类描述信息
 *
 * @author zhanghui
 * @date 2020/9/22 8:40 下午
 */
@Component
public class StorageHystrixClientFallback extends AbstractHystrixClientFallback<StorageRemoteClient> {
    @Override
    public StorageRemoteClient createDefaultMsg() {
        return () -> "storage default";
    }
}
