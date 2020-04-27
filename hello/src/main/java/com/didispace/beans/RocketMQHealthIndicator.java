package com.didispace.beans;

import java.security.cert.CertPathChecker;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RocketMQHealthIndicator implements HealthIndicator
{

	@Override
	public Health health()
	{
		// TODO Auto-generated method stub
		int errorCode = check();
		if(errorCode != 0)
		{
			return Health.down().withDetail("Error code", errorCode).build();
		}
		return Health.up().build();
	}
	
	private int check()
	{
		return 1;
	}

}
