package com.propertiesdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PropertiesBind {

    @Autowired
    private PropertiesConfiguration propertiesConfiguration;

    @PostConstruct
    private void writeProperties() {
        System.out.println("Write properties firstname : " + propertiesConfiguration.getFirstName());
    }


}
