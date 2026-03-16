package com.sai.restapi.user_management_system.annotations.userwithproject;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(summary = "Get all users assigned to projects", description = "Fetches all users assigned to projects along with all associated projects")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User with projects retrieved successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid userId provided")
})
public @interface GetAllUsersAssignedToProjectsDoc {
}
