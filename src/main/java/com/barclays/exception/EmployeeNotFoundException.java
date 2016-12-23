package com.barclays.exception;

/**
 * Created by knight on 21-12-2016.
 */
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String s){
        super(s);
    }
}
