package net.practice.employeeservice.exception;

public class NoDepartmentFoundException extends RuntimeException{

    public NoDepartmentFoundException(String message){
        super(message);
    }
}
