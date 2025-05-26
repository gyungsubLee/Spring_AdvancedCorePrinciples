package com.inflearn.lecture_prac.proxy.app.v1_proxy.interface_proxy;

import com.inflearn.lecture_prac.proxy.app.basic_ex.trace.TraceStatus;
import com.inflearn.lecture_prac.proxy.app.basic_ex.trace.logtrace.LogTrace;
import com.inflearn.lecture_prac.proxy.app.basic_ex.v1.OrderControllerV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderControllerInterfaceProxy implements OrderControllerV1 {

    private final OrderControllerV1 target;
    private final LogTrace logTrace;

    @GetMapping("/v1/request")
    @Override
    public String request(String itemId) {

        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.request()");
            // target 호출
            String result = target.request(itemId);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    @GetMapping("/v1/no-log")
    @Override
    public String noLog() {
        return target.noLog();
    }
}