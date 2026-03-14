package com.sai.restapi.user_management_system.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Integer id) {

        super("Task not found "+id);

    }
}
