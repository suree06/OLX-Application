package com.olx.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OlxGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxGatewayServerApplication.class, args);
	}

}
