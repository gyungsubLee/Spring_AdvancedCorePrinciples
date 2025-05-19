package com.inflearn.lecture_prac.trace.logtrace;

import com.inflearn.lecture_prac.trace.basic.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
