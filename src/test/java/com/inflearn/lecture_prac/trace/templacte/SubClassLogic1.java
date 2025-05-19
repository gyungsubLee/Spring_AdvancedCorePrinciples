package com.inflearn.lecture_prac.trace.templacte;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic1 extends AbstractTemplate {
    @Override
    protected void call() {
        log.info("비지니스 로직1 실행");
    }

    @Slf4j
    public abstract static class AbstractTemplate {


        public void execute() {
            long startTime = System.currentTimeMillis();
            // 비지니스 로직 실행
            call();
            // 비지니스 로직 종료
            long endTime = System.currentTimeMillis();
            long resultTime = endTime - startTime;
            log.info("resultTime={}", resultTime);
        }

        protected abstract void call();
    }
}
