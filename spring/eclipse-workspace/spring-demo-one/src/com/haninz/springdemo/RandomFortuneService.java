package com.haninz.springdemo;
import java.util.Random;

public class RandomFortuneService implements FortuneService {
	private String [] data = {"good luck", "beware today", "lol, it's life"};
	private Random myrandom = new Random();

	@Override
	public String getFortune() {
		int index = myrandom.nextInt(data.length);
		String word = data[index];
		return word;
	}

}
