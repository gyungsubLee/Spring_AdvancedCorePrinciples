package com.inflearn.lecture_prac.proxy.app.basic_ex.trace.logtrace;

import com.inflearn.lecture_prac.proxy.app.basic_ex.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
