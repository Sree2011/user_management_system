package com.sai.restapi.user_management_system.annotations.task;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "Get All Tasks")
@ApiResponse(responseCode = "200", description = "Tasks retrieved successfully")
public @interface GetAllTasksDoc {
}
