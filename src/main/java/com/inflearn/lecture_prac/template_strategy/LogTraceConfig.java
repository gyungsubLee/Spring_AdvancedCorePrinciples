package com.inflearn.lecture_prac.template_strategy;

import com.inflearn.lecture_prac.template_strategy.trace.logtrace.LogTrace;
import com.inflearn.lecture_prac.template_strategy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
//        return new FieldLogTrace();
        return new ThreadLocalLogTrace();
    }
}
