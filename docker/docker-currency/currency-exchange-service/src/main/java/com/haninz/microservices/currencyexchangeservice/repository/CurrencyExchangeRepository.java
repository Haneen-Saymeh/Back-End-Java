package com.haninz.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haninz.microservices.currencyexchangeservice.entity.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
//	CurrencyExchange findByFromAndTo(String from, String to);

	CurrencyExchange findByFromAndTo(String from, String to);

}
