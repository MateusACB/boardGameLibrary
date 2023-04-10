package br.com.boardGameLibrary.exceptions;

public class ExpansionWithSameNameException extends RuntimeException{
    public ExpansionWithSameNameException() {
        super("A expansion with the same name already exists");
    }
}
