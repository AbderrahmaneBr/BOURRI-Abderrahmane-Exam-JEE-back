package org.example.examback.exceptions;

public class RemboursementNotFound extends RuntimeException {
    public RemboursementNotFound() {
        super("Remboursement not found");
    }
}
