package com.propertiesdemo;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "joker")
public class PropertiesConfiguration {

    private String firstName;
}
