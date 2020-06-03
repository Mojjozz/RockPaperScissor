package com.rps.gametest.Business.Exceptions;

public class NoMoreMovesException extends RuntimeException{
    public NoMoreMovesException(String Id){
        super(Id);
    }
}
