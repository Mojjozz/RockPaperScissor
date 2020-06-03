package com.morganjohansson.gametest.Business.Exceptions;

public class GameNotFoundException extends RuntimeException{
    public GameNotFoundException(String Id){
        super(Id);
    }


}
