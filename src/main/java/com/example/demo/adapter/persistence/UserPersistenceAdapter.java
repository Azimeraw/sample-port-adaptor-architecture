package com.example.demo.adapter.persistence;

import com.example.demo.domain.User;
import com.example.demo.domain.port.UserPersistencePort;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class UserPersistenceAdapter implements UserPersistencePort {

    private final SpringDataUserRepository springDataUserRepository;

    public UserPersistenceAdapter(SpringDataUserRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public User saveUser(User user) {
        // Directly convert domain User to persistence UserEntity
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());

        UserEntity savedEntity = springDataUserRepository.save(entity);

        // Return the domain User created from the saved entity
        return new User(savedEntity.getId(), savedEntity.getName());
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return springDataUserRepository.findById(id)
                .map(entity -> new User(entity.getId(), entity.getName()));
    }
}
