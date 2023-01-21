package com.yarikonen.web44.Services;

import com.yarikonen.web44.Annotations.LogEntryExit;
import com.yarikonen.web44.Data.Dot;
import com.yarikonen.web44.Data.User;
import com.yarikonen.web44.Repositories.UserRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository ){
        this.userRepository=userRepository;
    }
    @LogEntryExit
    public User addUser(User user){
        return(userRepository.save(user));
    }

    @LogEntryExit
    public boolean existsByLogin(String login) { return userRepository.existsByLogin(login);}

    @LogEntryExit
    public User getByLogin(String login){
        return(userRepository.findUserByLogin(login));
    }
}
