package com.sai.restapi.user_management_system.exception;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(Integer id) {

        super("Comment not found "+id);
    }
}
