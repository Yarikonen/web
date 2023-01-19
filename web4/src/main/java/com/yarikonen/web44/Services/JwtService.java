package com.yarikonen.web44.Services;

import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.util.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;


@Slf4j
@Service
public class JwtService {
    private final Algorithm jwtAccessSecret;
    private final Algorithm jwtRefreshSecret;

    public JwtService(
            @Value("${jwt.secret.access}") String jwtAccessSecret,
            @Value("${jwt.secret.refresh}") String jwtRefreshSecret
    ) {
        this.jwtAccessSecret = Algorithm.HMAC256(jwtAccessSecret);
        this.jwtRefreshSecret = Algorithm.HMAC256(jwtRefreshSecret);
    }
    public String generateAccessToken(String login){
        return JWT.create()
                .withClaim("login", login)
                .withExpiresAt(Instant.now().plus(5, ChronoUnit.MINUTES))
                .sign(jwtAccessSecret);
    }
    public String generateRefreshToken(String login){
        return JWT.create()
                .withClaim("login", login)
                .withExpiresAt(Instant.now().plus(30, ChronoUnit.DAYS))
                .sign(jwtRefreshSecret);
    }
    public boolean validateToken(String token){
        try {
            JWTVerifier verifier = JWT.require(jwtAccessSecret).build();
            verifier.verify(token);
        }
        catch(TokenExpiredException exp){
            return false;
        }
        return true;
    }
}



