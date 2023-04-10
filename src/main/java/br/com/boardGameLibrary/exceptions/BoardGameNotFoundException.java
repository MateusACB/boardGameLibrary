package br.com.boardGameLibrary.exceptions;

public class BoardGameNotFoundException extends RuntimeException{
    public BoardGameNotFoundException() {
        super("Board game not found");
    }
}
