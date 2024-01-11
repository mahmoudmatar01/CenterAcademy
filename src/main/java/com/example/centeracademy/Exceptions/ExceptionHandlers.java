package com.example.centeracademy.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundCourseException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public final ResponseEntity<ErrorResponse>handleCourseNotFoundException(final NotFoundCourseException courseException){
        ErrorResponse errorResponse=new ErrorResponse("404",courseException.getMessage());
        return  new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(GlobalExceptionClass.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ResponseEntity<ErrorResponse>handleCourseGlobalException(final GlobalExceptionClass courseException){
        ErrorResponse errorResponse=new ErrorResponse(courseException.getMessage());
        return  new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
