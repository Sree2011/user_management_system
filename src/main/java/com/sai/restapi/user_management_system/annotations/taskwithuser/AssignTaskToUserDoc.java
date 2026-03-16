package com.sai.restapi.user_management_system.annotations.taskwithuser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(summary = "Assigns task to a user", description = "Assigns task to a user based on taskId and userId")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Task assigned to User successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid userId or taskId provided")
})
public @interface AssignTaskToUserDoc {
}
