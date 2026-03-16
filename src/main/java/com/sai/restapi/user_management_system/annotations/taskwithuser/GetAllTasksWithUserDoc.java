package com.sai.restapi.user_management_system.annotations.taskwithuser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(summary = "Get all tasks assigned to users", description = "Fetches all tasks assigned to users along with all associated userIds")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "tasks with users retrieved successfully"),
//        @ApiResponse(responseCode = "400", description = "Invalid userId provided")
})
public @interface GetAllTasksWithUserDoc {
}
