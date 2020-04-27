package com.didispace.web;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
	private final Logger logger = Logger.getLogger(getClass());
	
	@RequestMapping("/hello")
	public String index()
	{
		logger.info("start to call Hello-service");
		return "Hello World";
	}
	
	@RequestMapping(value="/hello1", method=RequestMethod.GET)
	public String hello1(@RequestParam String name)
	{
		return "Hello: " + name;
	}
	
	@RequestMapping(value="/hello2", method=RequestMethod.GET)
	public User hello2(@RequestHeader String name, @RequestHeader Integer age)
	{
		return new User(name, age);
	}
	
	@RequestMapping(value="/hello3", method=RequestMethod.POST)
	public String hello3(@RequestBody User user)
	{
		return "Hello :" + user.getName() + "," + user.getAge();
	}
	
	@RequestMapping("/users")
	public String users(@RequestParam("id") long id)
	{
		return "user id:" + id;
	}
	
    
//	
//	@Autowired
//	private Registration registration;
//	
//	@Autowired
//	private DiscoveryClient client;
	
	
//	@RequestMapping(value = "/testBalance", method = RequestMethod.GET)
//    public String testBalance(@RequestParam String param) {
//        ServiceInstance instance = serviceInstance();
//        String result = "/testBalance, host:port=" + instance.getUri()  + ", "
//                + "service_id:" + instance.getServiceId();
//        logger.info(result);
//        return "From Service-A , " + result;
//    }
//
//    public ServiceInstance serviceInstance() {
//        List<ServiceInstance> list = client.getInstances(registration.getServiceId());
//        if (list != null && list.size() > 0) {
//            for(ServiceInstance itm : list){
//                if(itm.getPort() == 2001)
//                    return itm;
//            }   
//        }
//        return null;
//    }
	
//	@RequestMapping(value="/hello",method=RequestMethod.GET)
//	public String index()
//	{
//		ServiceInstance instance = serviceInstance();
//		String result = "hello, host:port=" + instance.getUri() + ", "
//				+ "service_id" + instance.getServiceId();
//		return "From Service-A , " + result;
//	}
	
//	private ServiceInstance serviceInstance()
//	{
//      List<ServiceInstance> list = client.getInstances(registration.getServiceId());
//      if (list != null && list.size() > 0) {
//          for(ServiceInstance itm : list){
//              if(itm.getPort() == 2001)
//                  return itm;
//          }   
//      }
//      return null;
//		List<ServiceInstance> list = client.getInstances(registration.getServiceId());
//		if(list != null && list.size() > 0)
//		{
//			for (ServiceInstance item : list)
//			{
//				 if(item.getPort() == 2001)
//	                    return item;
//			}
//		}
//		return null;
//	}
}
