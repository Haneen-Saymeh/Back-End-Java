package com.haninz.springdemo.restfulweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haninz.springdemo.restfulweb.entity.Post;

public interface PostRepository extends JpaRepository<Post,Integer>{

}
