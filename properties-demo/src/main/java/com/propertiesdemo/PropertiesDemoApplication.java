package com.propertiesdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {PropertiesConfiguration.class})
public class PropertiesDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertiesDemoApplication.class, args);
    }

}
