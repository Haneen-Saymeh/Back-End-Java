package com.haninz.springdemo;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;
	
	public CricketCoach() {
		System.out.println("cricket coach: inside no args constructor!");
	}
	
	
    
	public void setEmailAddress(String emailAddress) {
		System.out.println("cricket coach: inside setter! for email");
		this.emailAddress = emailAddress;
	}



	public void setTeam(String team) {
		System.out.println("cricket coach: inside setter! for team");
		this.team = team;
	}



	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("cricket coach: inside setter!");
		this.fortuneService = fortuneService;
	}



	@Override
	public String getDailyWorkout() {
		
		return "practice circketing";
	}

	@Override
	public String getDailyFortune() {
		return "cricketing today! " + fortuneService.getFortune();
	}

}
