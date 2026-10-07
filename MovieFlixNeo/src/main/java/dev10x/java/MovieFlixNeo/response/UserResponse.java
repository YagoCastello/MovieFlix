package dev10x.java.MovieFlixNeo.response;

import lombok.Builder;

@Builder
public record UserResponse(Long id, String name, String email) {

}
