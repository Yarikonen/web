package com.yarikonen.web44.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AuthException extends RuntimeException {

        public AuthException(String msg) {
            super("Authentification error : " + msg);
        }
    }
