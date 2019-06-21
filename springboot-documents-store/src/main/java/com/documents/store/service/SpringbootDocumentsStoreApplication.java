package com.documents.store.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDocumentsStoreApplication {

    public static void main(String[] args) {
        if (args.length == 0) {
           System.out.println("SpringbootDocumentsStoreApplication.main() - Missing Cache Size");
        }
        SpringApplication.run(SpringbootDocumentsStoreApplication.class, args);
    }
}
