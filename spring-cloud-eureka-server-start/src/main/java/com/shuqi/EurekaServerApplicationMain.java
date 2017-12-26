package com.shuqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplicationMain.class, args);
        System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + " EurekaServerApplicationMain started!");
    }
}
