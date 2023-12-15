package com.capgemini.programowanie.obiektowe;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException() {
        super();
    }

    public ClientNotFoundException(String message) {
        super(message);
    }
}