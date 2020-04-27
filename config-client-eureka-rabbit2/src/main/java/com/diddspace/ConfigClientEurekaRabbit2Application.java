package com.diddspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientEurekaRabbit2Application {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientEurekaRabbit2Application.class, args);
	}

}
