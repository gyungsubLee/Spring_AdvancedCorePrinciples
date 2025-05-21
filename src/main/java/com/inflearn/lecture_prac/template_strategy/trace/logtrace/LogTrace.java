package com.inflearn.lecture_prac.template_strategy.trace.logtrace;

import com.inflearn.lecture_prac.template_strategy.trace.basic.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
