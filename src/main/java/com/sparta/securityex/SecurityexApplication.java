package com.sparta.securityex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SecurityexApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityexApplication.class, args);
    }

}
