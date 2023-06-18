package com.helloworld.epidemicmanagement.exception;

/**
 * @author fsyj
 */
public class UserPasswordNotMatchException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserPasswordNotMatchException() {
        super("user.password.not.match");
    }
}
