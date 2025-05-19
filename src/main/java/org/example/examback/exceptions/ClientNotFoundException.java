package org.example.examback.exceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(){
        super("Client not found");
    }
}
