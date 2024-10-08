package net.practice.employeeservice.exception;

public class NoEmployeeFoundException extends RuntimeException{

    public NoEmployeeFoundException(String message) {
        super(message);
    }
}
