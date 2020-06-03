package com.rps.gametest.Business.Enums;


/*
* Rules enum that maps the different moves and which beats what
 */
public enum Rules{
    ROCK{
        @Override
        public boolean beats(Rules other){

            return other == SCISSOR;
        }
    },

    SCISSOR{
        @Override
        public boolean beats(Rules other){

            return other == PAPER;
        }
    },

    PAPER{
        @Override
        public boolean beats(Rules other){

            return other == ROCK;
        }
    };


    public abstract boolean beats(Rules other);
    public boolean isNotInEnum(String other){
        return true;
    }
}
