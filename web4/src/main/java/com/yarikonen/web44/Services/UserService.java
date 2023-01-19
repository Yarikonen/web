package com.yarikonen.web44.Services;

import com.yarikonen.web44.Annotations.LogEntryExit;
import com.yarikonen.web44.Data.Dot;
import com.yarikonen.web44.Data.User;
import com.yarikonen.web44.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository ){
        this.userRepository=userRepository;
    }
    @LogEntryExit
    public void addUser(User user){
        userRepository.save(user);
    }
}