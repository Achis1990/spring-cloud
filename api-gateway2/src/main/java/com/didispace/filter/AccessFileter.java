package com.didispace.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.valves.rewrite.Substitution.StaticElement;
import org.slf4j.*;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AccessFileter extends ZuulFilter
{
	private static Logger logger  = LoggerFactory.getLogger(AccessFileter.class);

	@Override
	public boolean shouldFilter()
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException
	{
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("Send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        Object accessToken = request.getParameter("accessToken");
        if(accessToken != null)
        {
        	logger.info("access token is empty");
        	ctx.setSendZuulResponse(false);
        	ctx.setResponseStatusCode(401);
        }
		// TODO Auto-generated method stub
        logger.info("access token ok");
		return null;
	}

	@Override
	public String filterType()
	{
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
