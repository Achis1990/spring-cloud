package com.didispace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.didispace.filter.AccessFileter;

@EnableZuulProxy
@SpringBootApplication
public class ApiGateway2Application {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateway2Application.class, args);
	}
	
	@Bean
	public AccessFileter accessFileter()
	{
		return new AccessFileter();
	}
}
