package br.com.boardGameLibrary.exceptions;

public class ExpansionNotFoundException extends RuntimeException{
    public ExpansionNotFoundException() {
        super("Expansion not found");
    }
}
