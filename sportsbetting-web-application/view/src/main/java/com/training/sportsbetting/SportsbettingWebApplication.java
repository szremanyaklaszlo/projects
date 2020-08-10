package com.training.sportsbetting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.training.sportsbetting")
public class SportsbettingWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsbettingWebApplication.class,args);
    }

}
