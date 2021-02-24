package com.wba.api.customerest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableAutoConfiguration
@SpringBootApplication
public class CustomerRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerRestApplication.class, args);
    }


}
