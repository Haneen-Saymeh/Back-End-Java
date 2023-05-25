package com.luv2code.springsecurity.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	UserBuilder users = User.builder();

	auth.inMemoryAuthentication()
	.withUser(users.username("john").password(passwordEncoder.encode("test123")).roles("EMPLOYEE"))
	.withUser(
	users.username("mary").password(passwordEncoder.encode("test123")).roles("EMPLOYEE", "MANAGER"))
	.withUser(
	users.username("susan").password(passwordEncoder.encode("test123")).roles("EMPLOYEE", "ADMIN"));
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMIN")
//		.anyRequest().authenticated()  // for authenticated users, ones with valid logins
		.and()
		.formLogin()
		    .loginPage("/loginPage")
		    .loginProcessingUrl("/authenticateTheUser")
		    .permitAll()
		    .and()
		    .logout()
		    .permitAll()
		    .and()
		    .exceptionHandling().accessDeniedPage("/access-denied");
		    
	}
	

}
