package com.haninz.springdemo;

import org.springframework.stereotype.Component;
import java.util.Random;
@Component
public class RandomFortuneService implements FortuneService {
	private String [] data = {"good luck today", "may the odds be with you", "no much luck here"};
	private Random random = new Random();

	@Override
	public String getFortune() {
		int index = random.nextInt(data.length);
		String fortune = data[index];
		return fortune;
	}

}
