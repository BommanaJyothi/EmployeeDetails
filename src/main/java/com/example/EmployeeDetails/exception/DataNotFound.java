package com.example.EmployeeDetails.exception;

public class DataNotFound extends ExceptionMessage{
    public DataNotFound(String message, int httpCode, String description) {
        super(message, httpCode, description);
    }

    public DataNotFound(String message, String description) {
        this(message, 404, description);
    }
}
