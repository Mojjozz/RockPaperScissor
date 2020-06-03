package com.rps.gametest.Business.Exceptions;

public class WaitingForPlayerException extends RuntimeException{
    public WaitingForPlayerException(String Id){
        super(Id);
    }
}
