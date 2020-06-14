package com.yanzu.flights;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yanzu.flights.mapper")
@SpringBootApplication
public class FlightsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightsApplication.class, args);
    }

}
