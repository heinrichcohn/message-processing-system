package com.example.msgsys.ingestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.msgsys")
public class IngestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IngestServiceApplication.class, args);
    }

}
