package com.didispace.web;

import java.util.List;

import org.apache.catalina.LifecycleListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.util.StringUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class UserService
{
	@Autowired
	public RestTemplate restTemplate;
	
	@HystrixCollapser(batchMethod="findAll", collapserProperties= {
			@HystrixProperty(name="timerDelayInMilliseconds", value="100")
	})
	public User Find(Long id)
	{
		return null;
	}
	
	@HystrixCommand
	public List<User> findAll(List<Long> ids)
	{
		@SuppressWarnings("unchecked")
		List<User> forObject = (List<User>)restTemplate.getForObject("http://SERVICE-HELLO/springboot-hello/users?ids={1}", 
				List.class, org.apache.commons.lang.StringUtils.join(ids, ","));
		return forObject;
		
	}
}
