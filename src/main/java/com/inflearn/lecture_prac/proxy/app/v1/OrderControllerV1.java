package com.inflearn.lecture_prac.proxy.app.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public interface OrderControllerV1 {

    String request(@RequestParam("itemId") String itemId);

    String noLog();
}