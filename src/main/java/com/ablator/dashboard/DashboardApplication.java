package com.ablator.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DashboardApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DashboardApplication.class, args);
    }

}
