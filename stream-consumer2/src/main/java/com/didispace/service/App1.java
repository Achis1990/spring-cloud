package com.didispace.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

import com.didispace.StreamConsumer2Application;
//消息反馈，如需使用，取消下行注释
@EnableBinding(value= {Processor.class})
public class App1
{
	private static Logger logger = LoggerFactory.getLogger(StreamConsumer2Application.class);
	
	//接收字符串
//	@StreamListener(Processor.INPUT)
//	@SendTo(Processor.OUTPUT)
//	public Object receiveFromInput(Object payload)
//	{
//		logger.info("Received:" +payload);
//		return "from channel input return:" + payload;
//	}
	
	//接收User对象
	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public Object receiveFromInput(User user)
	{
		logger.info("Received:" +user);
		return "from channel input return:" + user;
	}
}
