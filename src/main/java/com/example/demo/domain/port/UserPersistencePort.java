package com.example.demo.domain.port;

import com.example.demo.domain.User;
import java.util.Optional;

public interface UserPersistencePort {
    User saveUser(User user);
    Optional<User> getUserById(Long id);
}
