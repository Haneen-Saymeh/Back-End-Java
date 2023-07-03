package com.haninz.movieinfoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haninz.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {
	
	
	@GetMapping("/{movieId}")
	public Movie getMovie(@PathVariable String movieId) {
		return new Movie(movieId, "Iron Man");
		
	}
	
	

}
