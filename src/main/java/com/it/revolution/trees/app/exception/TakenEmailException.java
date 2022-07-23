package com.it.revolution.trees.app.exception;

import lombok.Getter;

@Getter
public class TakenEmailException extends Exception{

    private final String email;

    public TakenEmailException(String email){
        this(email, "User with email " + email + " already exists, try another one.");
    }

    public TakenEmailException(String email, String message){
        super(message);
        this.email = email;
    }

}
