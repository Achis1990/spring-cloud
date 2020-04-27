package com.didispace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.didispace.web.HelloService;

@RestController
public class ConsumerController
{
//	@Autowired
//	RestTemplate restTemplate;
	@Autowired
	HelloService helloService;
	
	@RequestMapping(value="/consumer-ribbon",method=RequestMethod.GET)
	public String helloConsumer()
	{
		return helloService.helloService();
//		String result = restTemplate.getForEntity("http://SERVICE-HELLO/springboot-hello/hello", 
//				String.class).getBody();
//		return result;
	}
}
