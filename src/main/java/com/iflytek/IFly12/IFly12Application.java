package com.iflytek.IFly12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class IFly12Application {
    public static void main(String[] args) {
        SpringApplication.run(IFly12Application.class, args);
    }
}
