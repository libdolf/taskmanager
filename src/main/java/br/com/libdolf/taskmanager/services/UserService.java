package br.com.libdolf.taskmanager.services;

import br.com.libdolf.taskmanager.models.User;
import br.com.libdolf.taskmanager.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public void save(User user) {
        repository.save(user);
    }

}
