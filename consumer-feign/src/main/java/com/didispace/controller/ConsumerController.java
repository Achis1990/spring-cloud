package com.didispace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.didispace.service.HelloService;
import com.didispace.service.User;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

@RestController
public class ConsumerController
{
	@Autowired
	HelloService helloService;
	
	@RequestMapping(value="consumer-feign",method=RequestMethod.GET)
	public String HelloConsumer()
	{
		return helloService.Hello();
	}
	
	@RequestMapping(value="consumer-feign2",method=RequestMethod.GET)
	public String HelloConsumer2()
	{
		StringBuilder buider = new StringBuilder();
		buider.append(helloService.Hello()).append("\n");
		buider.append(helloService.Hello1("DIDI")).append("\n");
		buider.append(helloService.Hello2("DIDI", 30)).append("\n");
		buider.append(helloService.Hello3(new User("DIDI", 30))).append("\n");
		return buider.toString();
	}
}
