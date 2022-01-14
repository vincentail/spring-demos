package com.vincent.springdemos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SpringDemosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemosApplication.class, args);
    }

}
