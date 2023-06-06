package com.ablator.dashboard.tests;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CCConfig {

    @Bean
    public CC cc1(){
        return new CC("1");
    }

    @Bean
    public CC cc2(){
        return new CC("2");
    }
}
