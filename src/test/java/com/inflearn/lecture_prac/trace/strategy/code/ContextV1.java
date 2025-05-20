package com.inflearn.lecture_prac.trace.strategy.code;

import com.inflearn.lecture_prac.trace.strategy.code.Strategy;
import lombok.extern.slf4j.Slf4j;

/**
 * 필드에 전략 보관
 */
@Slf4j
public class ContextV1 {

    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();

        // 비지니스 로직 실행
        strategy.call();  // 위임, composition
        // 비지니스 로직 종료

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime {}", resultTime);
    }
}