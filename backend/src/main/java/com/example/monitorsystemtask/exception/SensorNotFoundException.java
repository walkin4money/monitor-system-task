package com.example.monitorsystemtask.exception;

public class SensorNotFoundException extends RuntimeException{
    public SensorNotFoundException(String message){
        super(message);
    }
}
