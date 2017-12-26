package com.shuqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplicationMain {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplicationMain.class, args);
		System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + " EurekaClientApplicationMain started!");
	}

}
