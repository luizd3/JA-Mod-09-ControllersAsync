package com.mentorama.Mod09ControllersAsync.repositories;

import com.mentorama.Mod09ControllersAsync.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Async
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    CompletableFuture<Optional<User>> findOneById(final Long id);

    CompletableFuture<List<User>> findAllBy();

}
