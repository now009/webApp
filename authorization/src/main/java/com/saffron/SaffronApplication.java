package com.saffron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.saffron"})
@ComponentScan(basePackageClasses = {SaffronBasePackage.class})
public class SaffronApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaffronApplication.class, args);
    }
}
