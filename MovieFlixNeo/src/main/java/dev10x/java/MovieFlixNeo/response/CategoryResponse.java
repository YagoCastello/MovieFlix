package dev10x.java.MovieFlixNeo.response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}
