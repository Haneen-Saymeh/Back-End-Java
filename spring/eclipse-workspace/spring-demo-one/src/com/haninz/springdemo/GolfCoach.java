package com.haninz.springdemo;

public class GolfCoach implements Coach {
	private FortuneService fortuneService;
	
	public GolfCoach(FortuneService fortuneService ) {
		this.fortuneService=fortuneService;
		
	}

	@Override
	public String getDailyWorkout() {
		return "practice golfing";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
