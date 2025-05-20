package com.inflearn.lecture_prac.app.v5;

import com.inflearn.lecture_prac.trace.callback.TraceCallback;
import com.inflearn.lecture_prac.trace.callback.TraceTemplate;
import com.inflearn.lecture_prac.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public Object request(@RequestParam String itemId) {
        return template.execute(
        "OrderController.request()",
        new TraceCallback<>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        });
    }
}
