package com.techgatha.zuul;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import com.netflix.zuul.context.RequestContext;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreFilter extends ZuulFilter{
// userdb => cookie=> jsessionid
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		System.out.println("should filter");
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		System.out.println("run method invoked");
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		log.info("Request recieved for => "+request.getRequestURI());
		return request;
	}

	@Override
	public String filterType() {
		System.out.println("filter type");
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		System.out.println("filter orders");
		return 1;
	}

}
