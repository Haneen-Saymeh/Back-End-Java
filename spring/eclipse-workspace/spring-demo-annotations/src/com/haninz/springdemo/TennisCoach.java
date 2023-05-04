package com.haninz.springdemo;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		
		return "practice some tennis";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
