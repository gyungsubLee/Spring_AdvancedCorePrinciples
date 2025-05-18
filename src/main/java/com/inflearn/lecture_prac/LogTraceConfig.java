package com.inflearn.lecture_prac;

import com.inflearn.lecture_prac.trace.logtrace.FieldLogTrace;
import com.inflearn.lecture_prac.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }
}
