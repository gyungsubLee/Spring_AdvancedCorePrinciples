package com.inflearn.lecture_prac.pureproxy.proxy;

import com.inflearn.lecture_prac.pureproxy.proxy.code.ProxyPatternClient;
import com.inflearn.lecture_prac.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.excute();
        client.excute();
        client.excute();
    }
}
