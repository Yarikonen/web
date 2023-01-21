package com.yarikonen.web44.Services;


import com.yarikonen.web44.Data.User;
import com.yarikonen.web44.Exceptions.AuthException;
import com.yarikonen.web44.Utils.JwtToken;
import com.yarikonen.web44.Utils.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class AuthService {
    private UserService userService;
    private SecretService secretService;
    @Autowired
    public AuthService(UserService userService, SecretService secretService){
        this.userService=userService;
        this.secretService=secretService;
    }


    public JwtToken login(LoginForm loginForm) throws AuthException{
        if(!userService.existsByLogin(loginForm.getLogin())){
            throw new AuthException("No such user.");
        }
        User user = userService.getByLogin(loginForm.getLogin());
        if(!user.getPassword().equals(secretService.createHash(loginForm.getPassword()))){
            throw new AuthException("Wrong password.");
        }
        return secretService.generateToken(loginForm.getLogin());
    }
    public JwtToken register(LoginForm loginForm) throws AuthException{
        if(userService.existsByLogin(loginForm.getLogin())){
            throw new AuthException("Username taken.");
        }
        userService.addUser(new User(loginForm.getLogin(), loginForm.getPassword()));
        return secretService.generateToken(loginForm.getLogin());

    }



}
