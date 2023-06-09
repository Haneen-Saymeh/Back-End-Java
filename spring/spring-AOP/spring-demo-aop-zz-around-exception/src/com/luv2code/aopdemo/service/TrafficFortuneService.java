package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Expect heavy traffic this morning";
	}

	public String getFortune(boolean flagz) {
		if (flagz) {
			throw new RuntimeException("Highway is closed!!!");
		}
		return getFortune();
	}

}
