package com.example.EmployeeDetails.exception;

public class InValidDataProvided extends ExceptionMessage{
    public InValidDataProvided(String message, int httpCode, String description) {
        super(message, httpCode, description);
    }
    public InValidDataProvided(String message, String description) {
        this(message, 403, description);
    }
}
