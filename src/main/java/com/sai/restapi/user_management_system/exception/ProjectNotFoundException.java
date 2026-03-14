package com.sai.restapi.user_management_system.exception;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(Integer id) {

      super("Project Not Found" + id);
    }
}
