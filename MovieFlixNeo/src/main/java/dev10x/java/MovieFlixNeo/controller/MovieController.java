package dev10x.java.MovieFlixNeo.controller;

import dev10x.java.MovieFlixNeo.entity.Movie;
import dev10x.java.MovieFlixNeo.mapper.MovieMapper;
import dev10x.java.MovieFlixNeo.request.MovieRequest;
import dev10x.java.MovieFlixNeo.response.MovieResponse;
import dev10x.java.MovieFlixNeo.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest request) {
        Movie savedMovie = movieService.save(MovieMapper.toMovie(request));
        return ResponseEntity.ok(MovieMapper.toMovieResponse(savedMovie));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll() {
        return ResponseEntity.ok(movieService.findAll()
                .stream()
                .map(movie -> MovieMapper.toMovieResponse(movie))
                .toList());
    }

}
