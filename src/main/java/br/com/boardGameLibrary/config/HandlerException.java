package br.com.boardGameLibrary.config;

import br.com.boardGameLibrary.dto.ErrorDTO;
import br.com.boardGameLibrary.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BoardGameNotFoundException.class)
    public ErrorDTO handlerBoardGameNotFound(BoardGameNotFoundException ex){
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(BoardGameWithSameNameException.class)
    public ErrorDTO handlerBoardGameWithSameName(BoardGameWithSameNameException ex){
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ExpansionNotFoundException.class)
    public ErrorDTO handlerExpansionNotFound(ExpansionNotFoundException ex){
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ExpansionWithSameNameException.class)
    public ErrorDTO handlerExpansionWithSameName(ExpansionWithSameNameException ex){
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorDTO handlerUserNotFound(UserNotFoundException ex){
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserWithSameCpfException.class)
    public ErrorDTO handlerUserWithSameCpfException(UserWithSameCpfException ex){
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserWithSameEmailException.class)
    public ErrorDTO handlerUserWithSameEmailException(UserWithSameEmailException ex){
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

}
