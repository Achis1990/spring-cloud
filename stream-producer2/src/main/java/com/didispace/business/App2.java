package com.didispace.business;

import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import com.didispace.StreamProducer2Application;

@EnableBinding(value={Processor.class})
public class App2
{
	private static Logger logger = LoggerFactory.getLogger(StreamProducer2Application.class);
	
	//发送的消息为日期
//	@Bean
//	@InboundChannelAdapter(value=Processor.OUTPUT,poller = @Poller(fixedDelay = "3000"))
//	public MessageSource<Date> timerMessageSource()
//	{
//		return () -> new GenericMessage<>(new Date());
//	}
	
	//发送的消息为json字符串
	@Bean
	@InboundChannelAdapter(value=Processor.OUTPUT,poller = @Poller(fixedDelay = "3000"))
	public MessageSource<String> timerMessageSource()
	{
		return () -> new GenericMessage<>("{\"name\":\"didi\",\"age\":30}") ;
	}
	
	@StreamListener(Processor.INPUT)
	public void receiveFromOutput(Object payload)
	{
		logger.info("Received:" + payload);
	}
}
