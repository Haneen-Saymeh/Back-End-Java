package com.haninz.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class ChessCoach implements Coach {

@Autowired
@Qualifier("randomFortuneService")
private FortuneService fortuneService;

public ChessCoach() {
	System.out.println("inside default constructor");
}

public FortuneService getFortuneService() {
	return fortuneService;
}

// this is run after constructor and dependecy injections
//define init method
@PostConstruct
public void startThings() {
	System.out.println("inside start things");
}

// define destroy method
@PreDestroy
public void destroyThings() {
	System.out.println("inside destroy things");
}
//setter injection
//@Autowired
//public void setFortuneService(FortuneService fortuneService) {
//	System.out.println("inside setter method!");
//	this.fortuneService = fortuneService;
//}


//method injection
//@Autowired
//public void doSomeCrazy(FortuneService theFortuneService) {
//	System.out.println("inside crazy method");
//	fortuneService = theFortuneService;
//}

	//constructor injection
//@Autowired
//public ChessCoach(FortuneService thefortuneService) {
//	fortuneService=thefortuneService;	
//}
	@Override
	public String getDailyWorkout() {
		return "practice Chess strategies";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
