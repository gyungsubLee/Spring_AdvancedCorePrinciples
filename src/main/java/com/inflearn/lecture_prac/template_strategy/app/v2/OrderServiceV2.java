package com.inflearn.lecture_prac.template_strategy.app.v2;

import com.inflearn.lecture_prac.template_strategy.trace.basic.HelloTraceV2;
import com.inflearn.lecture_prac.template_strategy.trace.basic.TraceId;
import com.inflearn.lecture_prac.template_strategy.trace.basic.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderService.orderItem()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
