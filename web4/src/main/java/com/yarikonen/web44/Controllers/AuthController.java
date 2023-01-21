package com.yarikonen.web44.Controllers;

import com.yarikonen.web44.Exceptions.AuthException;
import com.yarikonen.web44.Services.AuthService;
import com.yarikonen.web44.Services.UserService;
import com.yarikonen.web44.Utils.JwtToken;
import com.yarikonen.web44.Utils.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/auth")
@RestController
public class AuthController {
    AuthService authService;
    @Autowired
    AuthController(AuthService service){
        this.authService=service;
    }

    @PostMapping("login")
    public ResponseEntity<JwtToken> login(@RequestBody LoginForm loginForm){
        try {
            JwtToken jwtToken = authService.login(loginForm);
            return new ResponseEntity<>(jwtToken,HttpStatus.OK);
        }
        catch(AuthException exp) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,exp.getMessage());
        }
    }
    @PostMapping("register")
    public ResponseEntity<JwtToken> register(@RequestBody LoginForm loginForm){
        try {
            JwtToken jwtToken = authService.register(loginForm);
            return new ResponseEntity<>(jwtToken,HttpStatus.OK);
        }
        catch(AuthException exp) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,exp.getMessage());
        }
    }
}
