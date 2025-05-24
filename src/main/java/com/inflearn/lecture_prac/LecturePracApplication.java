package com.inflearn.lecture_prac;

import com.inflearn.lecture_prac.proxy.app.trace.logtrace.LogTrace;
import com.inflearn.lecture_prac.proxy.app.trace.logtrace.ThreadLocalLogTrace;
import com.inflearn.lecture_prac.proxy.app.v1_proxy.ConcreteProxyConfig;
import com.inflearn.lecture_prac.proxy.app.v1_proxy.InterfaceProxyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;


@Import(ConcreteProxyConfig.class)
@SpringBootApplication(scanBasePackages = "com.inflearn.lecture_prac.proxy.app")
public class LecturePracApplication {

    public static void main(String[] args) {
        SpringApplication.run(LecturePracApplication.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}


