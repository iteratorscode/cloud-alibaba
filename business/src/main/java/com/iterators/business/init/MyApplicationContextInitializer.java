package com.iterators.business.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置信息初始化类
 *
 * @author zhanghui
 * @date 2021/6/23 7:19 下午
 */
@Slf4j
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        // Map<String, Object> map = new HashMap<>(16);
        // map.put("spring.cloud.nacos.addr", "localhost:8848");
        // map.put("server.port", 9101);
        // map.put("spring.application.name", "ITERATORS");
        // // 可以通过Active Profile动态设置一些参数
        // String[] activeProfiles = environment.getActiveProfiles();
        // environment.getProperty("key");
        // log.info("active profiles: {}", activeProfiles);
        // map.put("spring.profiles.active", activeProfiles[0]);
        // propertySources.addLast(new MapPropertySource("key", map));
        // log.info("parent environment add property");
    }
}
