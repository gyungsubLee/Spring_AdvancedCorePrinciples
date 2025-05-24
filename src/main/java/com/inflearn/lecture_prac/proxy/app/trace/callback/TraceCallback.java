package com.inflearn.lecture_prac.proxy.app.trace.callback;

public interface TraceCallback<T> {
    T call();
}