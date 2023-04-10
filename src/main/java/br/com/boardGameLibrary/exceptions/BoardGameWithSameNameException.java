package br.com.boardGameLibrary.exceptions;

public class BoardGameWithSameNameException extends RuntimeException{
    public BoardGameWithSameNameException() {
        super("A board game with the same name already exists");
    }
}
