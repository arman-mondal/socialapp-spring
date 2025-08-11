package com.arman.socialapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.arman.socialapp")
public class SocialappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialappApplication.class, args);
    }
}
