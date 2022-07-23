package com.it.revolution.trees.app.exception;

public class BadAuthorizedCredentialsException extends Exception {

    public BadAuthorizedCredentialsException(){
        super("Incorrect login, or password!");
    }

}
