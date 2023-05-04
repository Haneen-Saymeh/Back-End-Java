package com.haninz.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SomeConfig {
	
	@Bean
	public FortuneService badFortuneService() {
		return new BadFortuneService();
	}
	
	@Bean
	public SomeCoach someCoach() {
		return new SomeCoach(badFortuneService());
	}

}
