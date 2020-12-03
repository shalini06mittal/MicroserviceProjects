package com.eduramp.ms.ForexService.repository;

import org.springframework.data.repository.CrudRepository;

import com.eduramp.ms.ForexService.model.CurrencyExcchange;

public interface ExchangeRepository extends CrudRepository<CurrencyExcchange, Long>{

	public CurrencyExcchange findByFromAndTo(String from,String to);
}
