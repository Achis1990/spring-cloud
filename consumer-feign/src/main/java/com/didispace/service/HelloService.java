package com.didispace.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="SERVICE-HELLO")
public interface HelloService
{
	@RequestMapping("/springboot-hello/hello")
	String Hello();
	
	@RequestMapping(value="/springboot-hello/hello1", method=RequestMethod.GET)
	String Hello1(@RequestParam String name);
	
	@RequestMapping(value="/springboot-hello/hello2", method=RequestMethod.GET)
	String Hello2(@RequestHeader String name, @RequestHeader Integer age);
	
	@RequestMapping(value="/springboot-hello/hello3", method=RequestMethod.POST)
	String Hello3(@RequestBody User user);
	
	
}
