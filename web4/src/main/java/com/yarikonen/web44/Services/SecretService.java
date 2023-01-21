package com.yarikonen.web44.Services;

import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.yarikonen.web44.Utils.JwtToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;


@Slf4j
@Service
public class SecretService {
    private final Algorithm jwtAccessSecret;
    private final Algorithm jwtRefreshSecret;
    private final MessageDigest encoder;

    public SecretService(
            @Value("${jwt.secret.access}") String jwtAccessSecret,
            @Value("${jwt.secret.refresh}") String jwtRefreshSecret
            ) throws NoSuchAlgorithmException {
        this.jwtAccessSecret = Algorithm.HMAC256(jwtAccessSecret);
        this.jwtRefreshSecret = Algorithm.HMAC256(jwtRefreshSecret);
        this.encoder = MessageDigest.getInstance("SHA-256");
    }
    public synchronized String createHash(String password) {
        String pepper = "4M0gu5";
        password = pepper +password;

        encoder.update(password.getBytes());

        return new String(encoder.digest());
    }
    public JwtToken generateToken(String login){
        return new JwtToken(generateAccessToken(login), generateRefreshToken(login));
    }
    private String generateAccessToken(String login){
        return JWT.create()
                .withClaim("login", login)
                .withExpiresAt(Instant.now().plus(5, ChronoUnit.MINUTES))
                .sign(jwtAccessSecret);
    }
    private String generateRefreshToken(String login){
        return JWT.create()
                .withClaim("login", login)
                .withExpiresAt(Instant.now().plus(30, ChronoUnit.DAYS))
                .sign(jwtRefreshSecret);
    }
    public boolean validateToken(JwtToken token){
        JWTVerifier verifier = JWT.require(jwtAccessSecret).build();
        verifier.verify(token.getAccessToken());
        return true;


    }
}



