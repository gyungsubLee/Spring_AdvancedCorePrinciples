package com.inflearn.lecture_prac.proxy.app.v1_proxy.concrete_proxy;

import com.inflearn.lecture_prac.proxy.app.trace.TraceStatus;
import com.inflearn.lecture_prac.proxy.app.trace.logtrace.LogTrace;
import com.inflearn.lecture_prac.proxy.app.v2.OrderRepositoryV2;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 target;
    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {

        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.save()");
            // target 호출
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
