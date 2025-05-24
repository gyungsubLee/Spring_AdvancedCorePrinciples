package com.inflearn.lecture_prac.pureproxy.concreteproxy;

import com.inflearn.lecture_prac.pureproxy.concreteproxy.code.ConcreteClient;
import com.inflearn.lecture_prac.pureproxy.concreteproxy.code.ConcreteLogic;
import com.inflearn.lecture_prac.pureproxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }

    @Test
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic); // 데코레이터 추가
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }
}
