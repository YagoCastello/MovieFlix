package dev10x.java.MovieFlixNeo.mapper;

import dev10x.java.MovieFlixNeo.entity.User;
import dev10x.java.MovieFlixNeo.request.UserRequest;
import dev10x.java.MovieFlixNeo.response.UserResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest request) {
        return User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();

    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
            .id(user.getId ())
            .name(user.getName())
            .email(user.getEmail())
            .build();
    }

}
