package com.morganjohansson.gametest.Business.Exceptions;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(String name){

        super(name);
    }
}
