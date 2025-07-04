package com.inflearn.lecture_prac.proxy.app.basic_ex.v2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;

//    @GetMapping("/v2/request")
    public String request(@RequestParam String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

//    @GetMapping("/v2/no-log")
    public String noLog() {
        return "ok";
    }
}