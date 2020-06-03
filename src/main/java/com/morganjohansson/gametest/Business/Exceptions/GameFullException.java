package com.morganjohansson.gametest.Business.Exceptions;

public class GameFullException extends RuntimeException{
    public GameFullException(String Id){
        super(Id);
    }
}
