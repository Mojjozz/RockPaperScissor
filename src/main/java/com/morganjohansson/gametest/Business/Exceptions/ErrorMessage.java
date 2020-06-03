package com.morganjohansson.gametest.Business.Exceptions;

public class ErrorMessage {
    private String Id;
    private String message;


    public ErrorMessage(String message){

        this.message = message;
    }
    public ErrorMessage(String Id, String message){
        this.Id = Id;
        this.message = message;
    }

    public String getId() {

        return Id;
    }

    public void setId(String id) {

        this.Id = id;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }
}
