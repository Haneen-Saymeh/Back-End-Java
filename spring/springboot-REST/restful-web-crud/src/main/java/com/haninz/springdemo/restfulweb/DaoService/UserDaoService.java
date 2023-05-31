package com.haninz.springdemo.restfulweb.DaoService;
import java.time.LocalDate;
import java.util.*;
import com.haninz.springdemo.restfulweb.entity.*;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users= new ArrayList<>();
	
	static {
		users.add(new User("Joe", LocalDate.now().minusYears(30)));
		users.add(new User("Tony", LocalDate.now().minusYears(25)));
		users.add(new User("Wang", LocalDate.now().minusYears(20)));
	}
	
	
	// find all users
	public List<User> findUsers(){
		return users;
	}
	
	
	// find one user
	
	public User findUser(int id) {
		
		return users.get(id);
	}
	
	public User saveUser(User user) {
		users.add(user);
		return user;
		
	}
	
	// delete a user
	
public void delUser(int id) {
		users.remove(id);
		
	}

}
