package com.iterators.business.feign.fallback;

import feign.hystrix.FallbackFactory;

/**
 * AbstractHystrixClient Fallback
 *
 * @author iterators
 * @date 2020/9/22 下午8:12
 */
public abstract class AbstractHystrixClientFallback<T> implements FallbackFactory<T> {
    @Override
    public T create(Throwable cause) {
        return createDefaultMsg();
    }

    public abstract T createDefaultMsg();
}
