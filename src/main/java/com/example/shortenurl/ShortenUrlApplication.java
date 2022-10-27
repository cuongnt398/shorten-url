package com.example.shortenurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class ShortenUrlApplication{


    public static void main(String[] args) {
        SpringApplication.run(ShortenUrlApplication.class, args);
    }

}
