package com.luv2code.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.luv2code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	// will hold data read from properties file
	@Autowired
	private Environment env;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// define a bean for view resolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//	return new BCryptPasswordEncoder();
//	}
	
	
	@Bean
	public DataSource securityDataSource() {
		// create connection pool
		ComboPooledDataSource securityDataSource= new ComboPooledDataSource();
		// set jdbc driver class
		// read from property file
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		// log the connection prop just for FYI
		logger.info("===>>> jdbc url"+ env.getProperty("jdbc.url"));
		logger.info("===>>> jdbc user"+ env.getProperty("jdbc.user"));
		
		// set database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		// set connection pool props
		securityDataSource.setInitialPoolSize(getIntProp("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProp("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProp("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProp("connection.pool.maxIdleTime"));
		return securityDataSource;
	}
	
	public int getIntProp(String propName) {
		String propVal = env.getProperty(propName);
		int propValue = Integer.parseInt(propVal);
		return propValue;
	}

}
