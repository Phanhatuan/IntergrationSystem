package com.example.testconnection2db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class TestConnection2DbApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestConnection2DbApplication.class, args);
    }

}
