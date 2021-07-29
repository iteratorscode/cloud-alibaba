package com.iterators.order.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Sentinel 配置类
 *
 * @author iterators
 * @date 2021/7/27 下午3:17
 */
@Configuration
public class SentinelConfig {

    @Bean
    public RequestOriginParser requestOriginParser() {
        return request -> request.getHeader("Origin");
    }
}
