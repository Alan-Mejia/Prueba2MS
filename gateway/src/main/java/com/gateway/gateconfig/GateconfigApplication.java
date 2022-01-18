package com.gateway.gateconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GateconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(GateconfigApplication.class, args);
	}

}
