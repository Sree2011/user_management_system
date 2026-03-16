package com.sai.restapi.user_management_system.annotations.userwithproject;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(summary = "Assign project to user", description = "Links an existing project to a user by their IDs")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Project successfully assigned to user"),
        @ApiResponse(responseCode = "400", description = "Invalid userId or projectId provided"),
        @ApiResponse(responseCode = "404", description = "User or project not found")
})
public @interface AssignProjectToUserDoc {
}