package com.rps.gametest.Business.Exceptions;

public class GameFullException extends RuntimeException{
    public GameFullException(String Id){
        super(Id);
    }
}
