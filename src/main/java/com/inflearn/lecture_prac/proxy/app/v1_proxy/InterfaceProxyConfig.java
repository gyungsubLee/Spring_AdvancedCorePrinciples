package com.inflearn.lecture_prac.proxy.app.v1_proxy;

import com.inflearn.lecture_prac.proxy.app.trace.logtrace.LogTrace;
import com.inflearn.lecture_prac.proxy.app.trace.logtrace.ThreadLocalLogTrace;
import com.inflearn.lecture_prac.proxy.app.v1.*;
import com.inflearn.lecture_prac.proxy.app.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import com.inflearn.lecture_prac.proxy.app.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }

    @Bean
    OrderControllerV1 target() {
        return new OrderControllerV1Impl(orderService(logTrace()));
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace) {
        OrderServiceV1Impl serviceImpl = new OrderServiceV1Impl(orderRepository(logTrace));
        return new OrderServiceInterfaceProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
        OrderRepositoryV1Impl repositoryImpl = new OrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(repositoryImpl, logTrace);
    }
}