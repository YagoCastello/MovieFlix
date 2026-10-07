package dev10x.java.MovieFlixNeo.repository;

import dev10x.java.MovieFlixNeo.entity.Category;
import dev10x.java.MovieFlixNeo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByCategoriesId(Long CategoryId);

    List<Movie> findTop5ByOrderByRatingDesc();

}
