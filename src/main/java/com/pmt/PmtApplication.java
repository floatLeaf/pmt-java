package com.pmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmtApplication.class, args);
    }

}
