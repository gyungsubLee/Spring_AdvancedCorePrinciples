package com.inflearn.lecture_prac.proxy.app.trace.template;

import com.inflearn.lecture_prac.template_strategy.trace.basic.TraceStatus;
import com.inflearn.lecture_prac.template_strategy.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public T execute(String message) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            // 로직 호출
            T result = call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();
}