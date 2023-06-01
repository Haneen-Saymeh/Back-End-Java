package com.haninz.springdemo.restfulweb.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import com.haninz.springdemo.restfulweb.DaoService.UserDaoService;
import com.haninz.springdemo.restfulweb.entity.User;
import com.haninz.springdemo.restfulweb.entity.UserNotFoundResponse;
import com.haninz.springdemo.restfulweb.repositories.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserController {
	@Autowired
	private UserDaoService userService;
	
	@Autowired
	private UserRepository repo;
	
	
	
	@GetMapping("/users")
	public List<User> findThemUsers(){
		return repo.findAll();
		
	}
	
	
	@GetMapping("/users/{id}")
	public EntityModel<User> findOneUser(@PathVariable int id){
		Optional<User> user= repo.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundResponse("User not Found!");
		}
		EntityModel<User> entity = EntityModel.of(user.get());
		WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).findThemUsers());
		entity.add(link.withRel("all-users"));
		return entity;
		
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user){
		User savedUser= repo.save(user);
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
		Optional<User> user= repo.findById(id);
		repo.delete(user.get());
		return "User has been deleted: " + id;
	}

}
