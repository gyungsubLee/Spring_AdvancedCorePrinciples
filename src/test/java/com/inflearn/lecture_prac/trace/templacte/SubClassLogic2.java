package com.inflearn.lecture_prac.trace.templacte;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SubClassLogic2 extends AbstractTemplate {
    @Override
    protected void call() {
        log.info("비지니스 로직2 실행");
    }
}
