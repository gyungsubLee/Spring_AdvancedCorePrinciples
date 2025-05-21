package com.inflearn.lecture_prac;

import com.inflearn.lecture_prac.proxy.config.AppV1Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@Import(AppV1Config.class)
@SpringBootApplication(scanBasePackages = "com.inflearn.lecture_prac.proxy.app.v1")
//@ComponentScan(basePackages = "com.inflearn.lecture_prac.template_strategy")
public class LecturePracApplication {

    public static void main(String[] args) {
        SpringApplication.run(LecturePracApplication.class, args);
    }

}



