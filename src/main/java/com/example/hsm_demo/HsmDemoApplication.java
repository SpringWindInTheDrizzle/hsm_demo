package com.example.hsm_demo;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.example.hsm_demo.repository.mapper")
public class HsmDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(HsmDemoApplication.class, args);
    }
}
