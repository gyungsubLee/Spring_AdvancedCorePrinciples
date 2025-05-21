package com.inflearn.lecture_prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.inflearn.lecture_prac.template_strategy")
@ComponentScan(basePackages = "com.inflearn.lecture_prac.proxy")
public class LecturePracApplication {

    public static void main(String[] args) {
        SpringApplication.run(LecturePracApplication.class, args);
    }

}



