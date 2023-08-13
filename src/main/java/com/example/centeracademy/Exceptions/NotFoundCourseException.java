package com.example.centeracademy.Exceptions;

public class NotFoundCourseException extends  RuntimeException{

    public NotFoundCourseException(String message){
        super(message);
    }
}
