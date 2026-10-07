package dev10x.java.MovieFlixNeo.Config;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import dev10x.java.MovieFlixNeo.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenService {

    @Value("${movieflix.security.secret}")

    private String secret;

    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("userId",user.getId())
                .withClaim("name",user.getName())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("API MovieFlixNeo")
                .sign(algorithm);

    }


    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("API MovieFlixNeo")
                    .build()
                    .verify(token)
                    .getSubject(); // retorna o email (subject)
        } catch (JWTVerificationException e) {
            return null;
        }
    }
}
