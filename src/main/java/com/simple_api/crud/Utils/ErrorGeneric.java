package com.simple_api.crud.Utils;

public class ErrorGeneric extends Exception {
    private String message;

    public ErrorGeneric(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
