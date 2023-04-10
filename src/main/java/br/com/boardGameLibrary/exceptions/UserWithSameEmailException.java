package br.com.boardGameLibrary.exceptions;

public class UserWithSameEmailException extends RuntimeException{
    public UserWithSameEmailException() {
        super("A user with the same e-mail already exists");
    }
}
