package com.inflearn.lecture_prac.pureproxy.proxy;

import com.inflearn.lecture_prac.pureproxy.proxy.code.CacheProxy;
import com.inflearn.lecture_prac.pureproxy.proxy.code.ProxyPatternClient;
import com.inflearn.lecture_prac.pureproxy.proxy.code.RealSubject;
import com.inflearn.lecture_prac.pureproxy.proxy.code.Subject;
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

    @Test
    void cacheProxyTest() {
        Subject realSubject = new RealSubject();
        Subject cacheSubject = new CacheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(cacheSubject);
        client.excute();
        client.excute();
        client.excute();
    }
}
