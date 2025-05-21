package com.inflearn.lecture_prac.pureproxy.proxy.code;

public class ProxyPatternClient {

    private Subject subject;

    public ProxyPatternClient(Subject subject) {
        this.subject = subject;
    }

    public void excute() {
        subject.operation();
    }
}
