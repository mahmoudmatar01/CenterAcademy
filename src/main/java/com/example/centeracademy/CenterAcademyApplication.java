package com.example.centeracademy;

import com.example.centeracademy.Exceptions.Global_Exception_handler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CenterAcademyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CenterAcademyApplication.class, args);
        Thread.setDefaultUncaughtExceptionHandler(new Global_Exception_handler());
    }

}
