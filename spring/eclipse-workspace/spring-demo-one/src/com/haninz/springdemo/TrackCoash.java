package com.haninz.springdemo;

public class TrackCoash implements Coach {
	private FortuneService fortuneService;
	

	public TrackCoash(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "run 5k daily";
	}

	@Override
	public String getDailyFortune() {
		
		return "just do this! " + fortuneService.getFortune();
	}
	
	public void startMyThings() {
		System.out.println("start my things method");
	}
	
	public void destroyMyThings() {
		System.out.println("destroy my things method");
	}
	

}
