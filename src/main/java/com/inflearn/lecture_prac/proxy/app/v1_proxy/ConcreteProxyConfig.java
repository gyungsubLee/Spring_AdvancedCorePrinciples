package com.inflearn.lecture_prac.proxy.app.v1_proxy;

import com.inflearn.lecture_prac.proxy.app.trace.logtrace.LogTrace;
import com.inflearn.lecture_prac.proxy.app.v1_proxy.concrete_proxy.OrderControllerConcreteProxy;
import com.inflearn.lecture_prac.proxy.app.v1_proxy.concrete_proxy.OrderRepositoryConcreteProxy;
import com.inflearn.lecture_prac.proxy.app.v1_proxy.concrete_proxy.OrderServiceConcreteProxy;
import com.inflearn.lecture_prac.proxy.app.v2.OrderControllerV2;
import com.inflearn.lecture_prac.proxy.app.v2.OrderRepositoryV2;
import com.inflearn.lecture_prac.proxy.app.v2.OrderServiceV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {
//
//    @Bean
//    public OrderControllerV2 orderControllerV2(LogTrace logTrace) {
//        OrderControllerV2 controllerImpl = new OrderControllerV2(orderSerivceV2(logTrace));
//        return new OrderControllerConcreteProxy(controllerImpl, logTrace);
//    }

    @Bean
    public OrderControllerV2 target2(LogTrace logTrace) {
        return new OrderControllerV2(orderSerivceV2(logTrace));
    }

    @Bean
    public OrderServiceV2 orderSerivceV2(LogTrace logTrace) {
        OrderServiceV2 orderServiceImpl = new OrderServiceV2(orderRepositoryV2(logTrace));
        return new OrderServiceConcreteProxy(orderServiceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV2 orderRepositoryV2(LogTrace logTrace) {
        OrderRepositoryV2 repositoryImpl = new OrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(repositoryImpl, logTrace);
    }

}
