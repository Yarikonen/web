package com.yarikonen.web44.Repositories;

import com.yarikonen.web44.Data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
