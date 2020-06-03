package com.morganjohansson.gametest.Business.Exceptions;

public class NameAlreadyInUse extends RuntimeException{
    public NameAlreadyInUse(String name){

        super(name);
    }
}
