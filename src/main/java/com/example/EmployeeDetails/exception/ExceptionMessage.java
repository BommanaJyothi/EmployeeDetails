package com.example.EmployeeDetails.exception;

public class ExceptionMessage extends Exception{
    public ExceptionMessage(String message, int httpCode, String description) {
        super(message);
        this.httpCode = httpCode;
        this.description = description;
    }

    private String message;
    private int httpCode;
    private String description;




}
