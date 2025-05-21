package com.inflearn.lecture_prac.trace.logtrace;

import com.inflearn.lecture_prac.template_strategy.trace.basic.TraceStatus;
import com.inflearn.lecture_prac.template_strategy.trace.logtrace.FieldLogTrace;
import com.inflearn.lecture_prac.template_strategy.trace.logtrace.LogTrace;
import org.junit.jupiter.api.Test;


class FieldLogTraceTest {

    LogTrace trace = new FieldLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus status1 = trace.begin("hello");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }
}