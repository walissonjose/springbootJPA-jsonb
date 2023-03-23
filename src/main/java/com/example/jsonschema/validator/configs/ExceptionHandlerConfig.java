package com.example.jsonschema.validator.configs;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerConfig {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public String runtimeHandler(RuntimeException error){
        return "Retornou um erro de Runtime =>" + error.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public String handleEntityNotFound(EntityNotFoundException error){
        return "Objeto nao encontrado" + error.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> handleValidation(MethodArgumentNotValidException ex) {
        final List<String> errors = new LinkedList<>();
        ex.getFieldErrors().forEach(error -> {
            errors.add(error.getDefaultMessage());
        });
        return errors;
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException ex) {
        String errorMessage = "Invalid input: " + ex.getMessage();
        return errorMessage;
    }

    @ExceptionHandler(IOException.class)
    public String handleIOException(IOException ex) {
        String error = ex.getMessage();
        return "Erro ao ler o arquivo: " + error;
    }

    @ExceptionHandler(ProcessingException.class)
    public String handleProcessingException(ProcessingException ex) {
        String error = ex.getMessage();
        return "Erro ao processar o esquema JSON: "+ error;
    }
}

