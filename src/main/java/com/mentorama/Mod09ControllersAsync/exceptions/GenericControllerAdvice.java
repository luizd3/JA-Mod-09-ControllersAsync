package com.mentorama.Mod09ControllersAsync.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.concurrent.CompletableFuture;

@ControllerAdvice
public class GenericControllerAdvice {

    @ExceptionHandler({UserNotFound.class})
    public CompletableFuture<ResponseEntity<String>> handle(final UserNotFound userNotFound) {
        final String usuarioNaoEncontrado = "Usuário não encontrado.";
        return CompletableFuture.completedFuture(new ResponseEntity<>(usuarioNaoEncontrado, HttpStatus.NOT_FOUND)) ;
    }
}
