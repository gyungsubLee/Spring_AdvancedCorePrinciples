package com.inflearn.lecture_prac.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AImpl implements AInterface {

    @Override
    public String call() {
        log.info("A 호출");
        return "a";
    }
}
