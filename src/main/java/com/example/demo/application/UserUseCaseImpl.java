package com.example.demo.application;

import com.example.demo.domain.User;
import com.example.demo.domain.port.UserPersistencePort;
import com.example.demo.domain.port.UserUseCase;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserUseCaseImpl implements UserUseCase {

    private final UserPersistencePort userPersistencePort;

    public UserUseCaseImpl(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public User registerUser(User user) {
        // You may add additional business validations here.
        return userPersistencePort.saveUser(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userPersistencePort.getUserById(id);
    }
}
