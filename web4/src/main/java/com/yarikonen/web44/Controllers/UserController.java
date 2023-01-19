package com.yarikonen.web44.Controllers;

import com.yarikonen.web44.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    UserService service;
    @Autowired
    UserController(UserService service){
        this.service=service;
    }
}
