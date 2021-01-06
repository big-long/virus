package com.kemyond.virus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.kemyond.virus.*"})
@MapperScan(value = {"com.kemyond.virus.dao"})
public class VirusApplication {

    public static void main(String[] args) {
        SpringApplication.run(VirusApplication.class, args);
    }

}
