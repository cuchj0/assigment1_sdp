package com.questforge.exception;

public class InvalidQuestException extends RuntimeException{
    public InvalidQuestException(String message){
        super(message);
    }
}
