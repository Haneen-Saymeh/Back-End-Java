package com.haninz.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.haninz.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.haninz.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	@Autowired
	private CurrencyExchangeRepository repo;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchangeValue(@PathVariable String from,@PathVariable String to ) {
//		 CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
		CurrencyExchange currencyExchange=repo.findByFromAndTo(from, to);
		if (currencyExchange == null) {
			throw new RuntimeException("not able to find the data!");
		}
		 String port = environment.getProperty("local.server.port");
		 currencyExchange.setEnvironment(port);
		 return currencyExchange;
		
	}

}
