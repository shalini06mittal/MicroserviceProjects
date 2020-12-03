package com.eduramp.ms.CurrencyExchangeService.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eduramp.ms.CurrencyExchangeService.model.ConversionBean;
import com.eduramp.ms.CurrencyExchangeService.service.ForexFeignClient;

@RestController
public class CurrencyExchangeController {

	@Autowired
	RestTemplate template;
//	
//	@RequestMapping("/exchange/from/{from}/to/{to}/quantity/{quantity}")
//	public ConversionBean calculateAmount(
//			@PathVariable String from,
//			@PathVariable String to,
//			@PathVariable BigDecimal quantity)
//	{
//		/*
//		 * 1) url hard coded => cloud environment, urls are dynamic
//		 * 2) url creation
//		 * 3) RestTemplate object creation
//		 * 4) Manually making rest calls
//		 * 
//		 * microservices  to communicate
//		 * deploy all the microservices in a server => communication
//		 * Located
//		 * discoverable
//		 * unique id 
//		 * registered with a unique id
//		 * ms1 and ms2 => common server
//		 * multiple instances of a ms2-1
//		 * load balancer
//		 * 
//		 * Eureka server
//		 * Eureka client => 
//		 */
//		//String url ="http://localhost:8000/currency-exchange/from/{from}/to/{to}";
//		String url ="http://FOREX-SERVICE/currency-exchange/from/{from}/to/{to}";
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("from",from);
//		map.put("to", to);
//		
//		ConversionBean bean = template.getForObject(url, ConversionBean.class, map);
//		bean.setQuantity(quantity);
//		bean.setTotalCalculatedAmount(quantity.multiply(bean.getConversionMultiple()));
//		return bean;
//	}

	@Autowired
	ForexFeignClient feignClient;
	
	@RequestMapping("/exchange/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionBean calculateAmount(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity)
	{
		System.out.println(template.getForObject("http://techgatha.com/movies.php",String.class) );
		ConversionBean bean = this.feignClient.getRates(from, to);
		bean.setQuantity(quantity);
		bean.setTotalCalculatedAmount(quantity.multiply(bean.getConversionMultiple()));
		return bean;
	}
	
}
