package com.yarikonen.web44.Repositories;

import com.yarikonen.web44.Data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByLogin(String login);
    boolean existsByLogin(String login);
}
