package com.inflearn.lecture_prac.proxy.app.basic_ex.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}