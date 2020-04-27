package com.didispace.hello;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.didispace.web.HelloController;

@SpringBootTest
class HelloApplicationTests {

	private MockMvc mvc;
	
	@BeforeEach
	public void SetupContext()
	{
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}
	
	@Test
	public void hello() throws Exception
	{
		String string = mvc.perform(MockMvcRequestBuilders.get("/hello")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		System.out.println("返回："+string); 
	}
}
