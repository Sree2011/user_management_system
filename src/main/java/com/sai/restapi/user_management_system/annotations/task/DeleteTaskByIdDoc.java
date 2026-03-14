package com.sai.restapi.user_management_system.annotations.task;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "Delete Task By Id")
@ApiResponse(responseCode = "204", description = "Task deleted successfully")
public @interface DeleteTaskByIdDoc {
}
