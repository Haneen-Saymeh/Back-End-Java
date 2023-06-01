package com.haninz.springdemo.restfulweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haninz.springdemo.restfulweb.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
