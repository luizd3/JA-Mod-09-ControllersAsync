package com.mentorama.Mod09ControllersAsync.controllers;

import com.mentorama.Mod09ControllersAsync.exceptions.UserNotFound;
import com.mentorama.Mod09ControllersAsync.models.User;
import com.mentorama.Mod09ControllersAsync.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/user")
@RestController
@Async
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public CompletableFuture<List<User>> findAll() {
        System.out.println("Controller Thread: " + Thread.currentThread().getName());
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public CompletableFuture<User> findById(@PathVariable("id") final Long id) {
        System.out.println("Controller Thread: " + Thread.currentThread().getName());
        return this.userService.findById(id)
                 .thenApply(x -> x.orElseThrow(UserNotFound::new));
//                .thenApply(user -> {
//                    try {
//                        return user.get();
//                    } catch (NoSuchElementException e) {
//                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//                    }
//        });
    }

    @PostMapping
    public CompletableFuture<User> save(@RequestBody final User user) {
        System.out.println("Controller Thread: " + Thread.currentThread().getName());
        return this.userService.save(user);
    }
}
