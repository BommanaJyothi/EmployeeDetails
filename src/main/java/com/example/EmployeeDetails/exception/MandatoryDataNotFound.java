package com.example.EmployeeDetails.exception;

public class MandatoryDataNotFound extends ExceptionMessage{


    public MandatoryDataNotFound(String message, int httpCode, String description) {
        super(message, httpCode, description);
    }
    public MandatoryDataNotFound(String message, String description) {
        this(message, 404, description);
    }

}
