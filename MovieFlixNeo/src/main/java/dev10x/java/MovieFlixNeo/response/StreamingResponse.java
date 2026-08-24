package dev10x.java.MovieFlixNeo.response;

import lombok.Builder;

@Builder
public record StreamingResponse(Long id, String name) {
}
