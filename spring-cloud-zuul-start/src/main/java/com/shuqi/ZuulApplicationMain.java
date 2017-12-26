package com.shuqi;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringCloudApplication
@EnableZuulProxy
public class ZuulApplicationMain {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplicationMain.class, args);
		System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + " ZuulApplicationMain started!");
	}

}
