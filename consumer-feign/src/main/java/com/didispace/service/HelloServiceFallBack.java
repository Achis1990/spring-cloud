package com.didispace.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallBack  implements HelloService
{
	@Override
	public String Hello()
	{
		return "error";
	}

	@Override
	public String Hello1(String name)
	{
		// TODO Auto-generated method stub
		return "HELLO1 ERROR";
	}

	@Override
	public String Hello2(String name, Integer age)
	{
		// TODO Auto-generated method stub
		return "HELLO2 ERROR";
	}

	@Override
	public String Hello3(User user)
	{
		// TODO Auto-generated method stub
		return "HELLO3 ERROR";
	}
}
