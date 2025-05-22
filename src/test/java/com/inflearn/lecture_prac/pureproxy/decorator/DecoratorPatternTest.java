package com.inflearn.lecture_prac.pureproxy.decorator;

import com.inflearn.lecture_prac.pureproxy.decorator.code.Component;
import com.inflearn.lecture_prac.pureproxy.decorator.code.DecoratorPatternClient;
import com.inflearn.lecture_prac.pureproxy.decorator.code.RealComponent;
import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }
}
