package com.yarikonen.web44.Exceptions;

import com.auth0.jwt.exceptions.TokenExpiredException;

import java.time.Instant;

public class AccessTokenExpiredException extends TokenExpiredException {
    public AccessTokenExpiredException(String message, Instant expiredOn) {
        super(message, expiredOn);
    }
}
