package com.haninz.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.haninz.springdemo")
@PropertySource("classpath:sport.prop")
public class SportConfig {
	
	// define a bean for sad fortune service
	
	// method name is the bean id
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define a bean for swim coach and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}
