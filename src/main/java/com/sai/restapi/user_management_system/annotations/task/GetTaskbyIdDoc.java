package com.sai.restapi.user_management_system.annotations.task;

import com.sai.restapi.user_management_system.utility.TaskExamples;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "Get Tasks by Id")
@ApiResponse(responseCode = "200", description = "Tasks retrieved successfully",
content = @Content(examples=@ExampleObject(name = "task success", value= TaskExamples.TASK200)))
public @interface GetTaskbyIdDoc {
}
