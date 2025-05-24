package com.inflearn.lecture_prac.proxy.app.trace.logtrace;

import com.inflearn.lecture_prac.proxy.app.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
