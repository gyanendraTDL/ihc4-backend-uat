package com.tdl.river;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Ihc4DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ihc4DemoApplication.class, args);
	}

}
