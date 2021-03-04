package com.hl.schoolbar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.hl.schoolbar.mapper"})
public class Schoolbar1Application {

    public static void main(String[] args) {
        SpringApplication.run(Schoolbar1Application.class, args);
    }

}
