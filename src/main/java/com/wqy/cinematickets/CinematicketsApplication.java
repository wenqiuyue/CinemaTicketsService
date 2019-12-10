package com.wqy.cinematickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class CinematicketsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinematicketsApplication.class, args);
    }

}
