package com.haninz.springdemo.restfulweb.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.haninz.springdemo.restfulweb.DaoService.UserDaoService;
import com.haninz.springdemo.restfulweb.entity.User;
import com.haninz.springdemo.restfulweb.entity.UserNotFoundResponse;

@RestController
public class UserController {
	@Autowired
	private UserDaoService userService;
	
	@GetMapping("/users")
	public List<User> findThemUsers(){
		return userService.findUsers();
		
	}
	
	
	@GetMapping("/users/{id}")
	public User findOneUser(@PathVariable int id){
		
		List<User> theUsers= userService.findUsers();
		if(id > theUsers.size() || id <0) {
			throw new UserNotFoundResponse("User not Found!");
		}
		
		return userService.findUser(id);
		
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User savedUser= userService.saveUser(user);
//		int id = indexOf(savedUser);
	
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(indexOf(savedUser)).toUri();
		return ResponseEntity.created(location).build();
		
	}


	private int indexOf(User savedUser) {
		List<User> theUsers= userService.findUsers();
		int id=theUsers.indexOf(savedUser);
		return id;
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.delUser(id);
		return "User has been deleted: " + id;
	}

}
