package com.inflearn.lecture_prac.proxy.app.basic_ex.trace.callback;

public interface TraceCallback<T> {
    T call();
}