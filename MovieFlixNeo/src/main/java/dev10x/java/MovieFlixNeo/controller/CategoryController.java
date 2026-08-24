package dev10x.java.MovieFlixNeo.controller;


import dev10x.java.MovieFlixNeo.entity.Category;
import dev10x.java.MovieFlixNeo.mapper.CategoryMapper;
import dev10x.java.MovieFlixNeo.request.CategoryRequest;
import dev10x.java.MovieFlixNeo.response.CategoryResponse;
import dev10x.java.MovieFlixNeo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movieflix/category")
public class CategoryController {


    private final CategoryService categoryService;

    @GetMapping("/listar")
    public ResponseEntity< List<CategoryResponse>> getAllCategories() {
        List<Category> categories = categoryService.findAll();
        List<CategoryResponse> list = categories
                .stream()
                .map(category -> CategoryMapper.toCategoryResponse(category))
                .toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/criar")
    public ResponseEntity< CategoryResponse> saveCategory(@RequestBody CategoryRequest request) {
        Category newCategory = CategoryMapper.toCategory(request);
        Category saveCategory = categoryService.salvar(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(saveCategory));

    }
    @GetMapping("encontre/{id}")
    public ResponseEntity< CategoryResponse>  getCategoryById(@PathVariable Long id){
      return categoryService.buscarPorId(id)
              .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
              .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
