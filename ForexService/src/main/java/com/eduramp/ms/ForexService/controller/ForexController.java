package com.eduramp.ms.ForexService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.eduramp.ms.ForexService.model.CurrencyExcchange;
import com.eduramp.ms.ForexService.repository.ExchangeRepository;

@RestController
public class ForexController {

	@Autowired
	ExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExcchange retrieveExchangeValue
            (@PathVariable String from, @PathVariable String to){

    	System.out.println(repository.count());
    	CurrencyExcchange exchangeValue =
                repository.findByFromAndTo(from, to);

        return exchangeValue;
    }

}

