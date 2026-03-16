package com.sai.restapi.user_management_system.annotations.taskwithuser;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(summary = "Get tasks assigned to user", description = "Fetches all tasks assigned to user by userId")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Tasks retrieved for user successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid userId provided")
})
public @interface GetAllTasksForUserDoc {
}
