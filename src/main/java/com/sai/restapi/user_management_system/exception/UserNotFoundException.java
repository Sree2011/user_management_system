package com.sai.restapi.user_management_system.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(Integer id) {

        super("User not found with id : "+id);
    }
}
