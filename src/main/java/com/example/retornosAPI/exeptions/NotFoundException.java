package com.example.retornosAPI.exeptions;

public abstract class NotFoundException extends Exception {
    public NotFoundException(String message) {
        super(message);
    }
}
