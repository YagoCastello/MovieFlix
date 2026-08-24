package dev10x.java.MovieFlixNeo.repository;

import dev10x.java.MovieFlixNeo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
