package com.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringBootContactServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootContactServiceApplication.class, args);
	}

}
