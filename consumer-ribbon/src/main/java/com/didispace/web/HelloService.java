package com.didispace.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;

@Service
public class HelloService
{
	@Autowired
	public RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="helloFallback")
	public String helloService()
	{
		String result = restTemplate.getForEntity("http://SERVICE-HELLO/springboot-hello/hello", 
				String.class).getBody();
		return result;
	}
	
	public String helloFallback()
	{
		return "error  Hello World";
	}
	
	
}
