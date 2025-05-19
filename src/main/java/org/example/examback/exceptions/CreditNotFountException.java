package org.example.examback.exceptions;

public class CreditNotFountException extends RuntimeException {
    public CreditNotFountException() {
        super("Credit not fount");
    }
}
