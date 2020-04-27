package com.didispace.tuibine2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableDiscoveryClient
@EnableTurbine
@SpringBootApplication
public class Tuibine2Application {

	public static void main(String[] args) {
		SpringApplication.run(Tuibine2Application.class, args);
	}

}
