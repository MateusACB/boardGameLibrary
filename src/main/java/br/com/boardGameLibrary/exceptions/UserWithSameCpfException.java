package br.com.boardGameLibrary.exceptions;

public class UserWithSameCpfException extends RuntimeException{
    public UserWithSameCpfException() {
        super("A user with the same CPF already exists");
    }
}
