package dev10x.java.MovieFlixNeo.service;

import dev10x.java.MovieFlixNeo.entity.Category;
import dev10x.java.MovieFlixNeo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category salvar(Category category){
        return categoryRepository.save(category);
    }

    public Optional< Category > buscarPorId(Long id){
        return categoryRepository.findById(id);
    }

    public void deletar(Long id){
        categoryRepository.deleteById(id);
    }
}
