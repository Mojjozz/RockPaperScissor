package com.rps.gametest.Business.Exceptions;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(String Id){

        super(Id);
    }
}
