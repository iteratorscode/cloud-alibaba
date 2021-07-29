package com.iterators.business.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.iterators.business.feign.AccountRemoteClient;
import com.iterators.business.feign.OrderRemoteClient;
import com.iterators.business.feign.StorageRemoteClient;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 购物 Service
 *
 * @author zhanghui
 * @date 2020/9/16 8:30 下午
 */
@Service
@AllArgsConstructor
public class ShoppingService {

    private final OrderRemoteClient orderRemoteService;
    private final AccountRemoteClient accountRemoteService;
    private final StorageRemoteClient storageRemoteService;

    @SentinelResource(value = "order")
    public String order() throws ExecutionException, InterruptedException {

        // 订单服务：根据采购需求创建订单。
        CompletableFuture<String> orderFuture = CompletableFuture.supplyAsync(orderRemoteService::create);

        // 仓储服务：对给定的商品扣除仓储数量。
        CompletableFuture<String> storageFuture = CompletableFuture.supplyAsync(storageRemoteService::product);

        // 帐户服务：从用户帐户中扣除余额。
        CompletableFuture<String> accountFuture = CompletableFuture.supplyAsync(accountRemoteService::deduction);

        // allOf 在所有 Future 对象完成后结束，并返回一个 future。
        CompletableFuture<List<String>> result = CompletableFuture.allOf(orderFuture, storageFuture, accountFuture)
                .thenApply((v) ->
                    Stream.of(orderFuture, storageFuture, accountFuture)
                            .map(future -> future.getNow("DEFAULT"))
                            .collect(Collectors.toList())
                );
        result.join();

        return StringUtils.join(result.get(), ",");
    }
}
