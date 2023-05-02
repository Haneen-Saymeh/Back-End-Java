package com.haninz.springdemo;

public class BaseballCoash implements Coach{
	// define a private field for the dependency
	private FortuneService fortuneService;
	// define s constructor for dependency injction
	public BaseballCoash(FortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "spend 30 mins on patting";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
