package com.haninz.springdemo;

public class BadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "bad bad bad!!!";
	}

}
