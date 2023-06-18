package com.helloworld.epidemicmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@MapperScan(basePackages = "com.helloworld.epidemicmanagement.mapper")
@ConfigurationPropertiesScan(basePackages = "com.helloworld.epidemicmanagement.config")
@SpringBootApplication
public class EpidemicManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EpidemicManagementApplication.class, args);
    }

}
