package com.haninz.springdemo;

public class SomeCoach implements Coach {
	private FortuneService fortuneService;
	
	public SomeCoach(FortuneService fortuneService) {
		this.fortuneService=fortuneService;
		
	}

	@Override
	public String getDailyWorkout() {
		
		return "practice something";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune() ;
	}

}
