package net.practice.departmentservice.exception;

public class NoDepartmentFound extends RuntimeException{

    public NoDepartmentFound(String message){
        super(message);
    }
}
