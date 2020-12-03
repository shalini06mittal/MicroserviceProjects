package com.eduramp.ms.CurrencyExchangeService.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eduramp.ms.CurrencyExchangeService.model.ConversionBean;

@FeignClient(name="FOREX-SERVICE")
public interface ForexFeignClient {
	@RequestMapping("/currency-exchange/from/{from}/to/{to}")
	public ConversionBean getRates(
			@PathVariable String from,
			@PathVariable String to);

}
