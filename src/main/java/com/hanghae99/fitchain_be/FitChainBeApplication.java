package com.hanghae99.fitchain_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FitChainBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitChainBeApplication.class, args);
    }

}
