package com.example.demo.domain.port;

import com.example.demo.domain.User;
import java.util.Optional;

public interface UserUseCase {
    User registerUser(User user);
    Optional<User> getUserById(Long id);
}
