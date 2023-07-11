package com.haninz.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.haninz.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.haninz.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	@Autowired
	private CurrencyExchangeRepository repo;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchangeValue(@PathVariable String from,@PathVariable String to ) {
//		 CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
		logger.info("retrieveExchangeValue called with {} to {}", from, to);
		CurrencyExchange currencyExchange=repo.findByFromAndTo(from, to);
		if (currencyExchange == null) {
			throw new RuntimeException("not able to find the data!");
		}
		 String port = environment.getProperty("local.server.port");
		//CHANGE-KUBERNETES
			String host = environment.getProperty("HOSTNAME");
			String version = "v12";
			
			currencyExchange.setEnvironment(port + " " + version + " " + host);
		 return currencyExchange;
		
	}

}
