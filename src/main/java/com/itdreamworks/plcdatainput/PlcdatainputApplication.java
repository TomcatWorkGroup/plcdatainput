package com.itdreamworks.plcdatainput;

import com.itdreamworks.plcdatainput.listener.ApplicationListeners;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
//@ServletComponentScan(basePackages = "com.itdreamworks.plcdatainput")
public class PlcdatainputApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlcdatainputApplication.class, args);
    }
}