package com.inflearn.lecture_prac.proxy.app.v1_proxy.concrete_proxy;

import com.inflearn.lecture_prac.proxy.app.basic_ex.trace.TraceStatus;
import com.inflearn.lecture_prac.proxy.app.basic_ex.trace.logtrace.LogTrace;
import com.inflearn.lecture_prac.proxy.app.basic_ex.v2.OrderControllerV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerConcreteProxy extends OrderControllerV2 {

    private final OrderControllerV2 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(OrderControllerV2 target2, LogTrace logTrace) {
        super(null);
        this.target = target2;
        this.logTrace = logTrace;
    }

    @GetMapping("/v2/request")
    @Override
    public String request(String itemId) {

        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.save()");
            // target 호출
            target.request(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
        return "proxy";
    }
}
