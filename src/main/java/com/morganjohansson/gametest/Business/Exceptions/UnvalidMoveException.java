package com.morganjohansson.gametest.Business.Exceptions;

public class UnvalidMoveException extends RuntimeException{
    public UnvalidMoveException(String move){
        super(move);
    }
}
