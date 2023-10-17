package com.tdl.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Ihc4EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ihc4EurekaApplication.class, args);
	}

}
