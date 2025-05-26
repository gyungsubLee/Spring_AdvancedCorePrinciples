package com.inflearn.lecture_prac.proxy.app.v1_proxy.concrete_proxy;

import com.inflearn.lecture_prac.proxy.app.basic_ex.trace.TraceStatus;
import com.inflearn.lecture_prac.proxy.app.basic_ex.trace.logtrace.LogTrace;
import com.inflearn.lecture_prac.proxy.app.basic_ex.v2.OrderControllerV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// NOTES: 순환 참조 문제가 발생 되어 임시로 주석 처리함
    // 이유: target2를 등록한 ConcreteProxyConfig를 스캔 범위에서 제외함
    //      따라서 수동 빈으로 등록하던 concrete class인 OrderControllerV2가 빈으로 등록되지 않아
    //      이를 상속하는 OrderControllerConcreteProxy를 빈으로 주입함 ( 다형성 )
    //      이로 인해 자기 자신을 참조하는 순환 참조 문제가 발생됨.
//@RestController
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
