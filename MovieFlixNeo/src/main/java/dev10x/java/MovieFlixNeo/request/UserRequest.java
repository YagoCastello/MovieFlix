package dev10x.java.MovieFlixNeo.request;

import lombok.Builder;

@Builder
public record UserRequest(String name, String email, String password) {
}
