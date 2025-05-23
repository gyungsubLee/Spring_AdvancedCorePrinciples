package com.inflearn.lecture_prac.trace.strategy;

import com.inflearn.lecture_prac.trace.strategy.code.ContextV2;
import com.inflearn.lecture_prac.trace.strategy.code.strategy.Strategy;
import com.inflearn.lecture_prac.trace.strategy.code.strategy.StrategyLogic1;
import com.inflearn.lecture_prac.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /**
     * 전략 패턴 적용
     */
    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

    /**
     * 전략 패턴 - 익명 내부 클래스
     */
    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 로직1 실행");
            }
        });

        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 로직2 실행");
            }
        });
    }
}
