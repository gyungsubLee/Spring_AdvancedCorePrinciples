package com.inflearn.lecture_prac.proxy.app.basic_ex.v2;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}