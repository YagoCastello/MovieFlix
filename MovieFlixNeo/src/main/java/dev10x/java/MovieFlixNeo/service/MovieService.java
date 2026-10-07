package dev10x.java.MovieFlixNeo.service;

import dev10x.java.MovieFlixNeo.entity.Category;
import dev10x.java.MovieFlixNeo.entity.Movie;
import dev10x.java.MovieFlixNeo.entity.Streaming;
import dev10x.java.MovieFlixNeo.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public Movie save(Movie movie) {
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStreamings(movie.getStreamings()));

        return movieRepository.save(movie);
    }



    public List<Movie> findAll() {
        return movieRepository.findAll();
    }



    public List<Movie> findByCategory(Long categoryId) {
        return movieRepository.findByCategoriesId(categoryId);
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }


    public Optional<Movie> update(Long movieId, Movie movie) {
        Optional<Movie> optMovie = movieRepository.findById(movieId);
        if (optMovie.isPresent()) {

            List<Category> categories = this.findCategories(movie.getCategories());
            List<Streaming> streamings = this.findStreamings(movie.getStreamings());



            Movie movieAtt = optMovie.get();
            movieAtt.setTitle(movie.getTitle());
            movieAtt.setDescription(movie.getDescription());
            movieAtt.setReleaseDate(movie.getReleaseDate());
            movieAtt.setRating(movie.getRating());

            movie.setCategories(categories);
            movie.setStreamings(streamings);



            return Optional.of(movieAtt);
        }
        return Optional.empty();
    }


    public void delete(Long id) {
        movieRepository.deleteById(id);
    }


    private List<Category> findCategories(List<Category> categories) {
        List<Category> categoryFound = new ArrayList<>();
        categories.forEach(category -> categoryService.buscarPorId(category.getId())
                .ifPresent(categoryFound::add));
        return categoryFound;
    }



    private List<Streaming> findStreamings(List<Streaming> streamings) {
        List<Streaming> streamingFound = new ArrayList<>();
        streamings.forEach(streaming -> streamingService.buscarPorId(streaming.getId())
                .ifPresent(streamingFound::add));
        return streamingFound;
    }



}
