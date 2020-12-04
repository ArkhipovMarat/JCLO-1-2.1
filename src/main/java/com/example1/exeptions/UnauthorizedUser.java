package com.example1.exeptions;

public class UnauthorizedUser extends RuntimeException{
    public UnauthorizedUser(String message) {
        super(message);
    }
}
