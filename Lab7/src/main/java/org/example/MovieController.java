package org.example.controller;

import org.example.model.Movie;
import org.example.repository.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository repository;


    public MovieController(MovieRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public List<Movie> getMovies() {
        return repository.findAll();
    }
}