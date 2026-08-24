package dev10x.java.MovieFlixNeo.mapper;

import dev10x.java.MovieFlixNeo.entity.Category;
import dev10x.java.MovieFlixNeo.request.CategoryRequest;
import dev10x.java.MovieFlixNeo.response.CategoryResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest) {
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }


    public static CategoryResponse toCategoryResponse(Category category) {
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
