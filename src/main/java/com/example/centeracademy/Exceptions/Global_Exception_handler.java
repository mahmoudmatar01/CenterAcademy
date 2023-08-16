package com.example.centeracademy.Exceptions;

public class Global_Exception_handler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Uncaught exception occurred in thread " + t.getName() + " : "+ e.getMessage());
    }
}
