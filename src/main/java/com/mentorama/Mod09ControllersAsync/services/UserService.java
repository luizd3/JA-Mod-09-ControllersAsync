package com.mentorama.Mod09ControllersAsync.services;

import com.mentorama.Mod09ControllersAsync.models.User;
import com.mentorama.Mod09ControllersAsync.repositories.UserRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Async("executorService")
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CompletableFuture<Optional<User>> findById(Long id) {
        System.out.println("Service thread: " + Thread.currentThread().getName());
        return this.userRepository.findOneById(id);
    }

    public CompletableFuture<List<User>> findAll() {
        System.out.println("Service thread: " + Thread.currentThread().getName());
        return this.userRepository.findAllBy();
    }

    public CompletableFuture<User> save(final User user) {
        System.out.println("Service thread: " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(this.userRepository.save(user));
    }
}
