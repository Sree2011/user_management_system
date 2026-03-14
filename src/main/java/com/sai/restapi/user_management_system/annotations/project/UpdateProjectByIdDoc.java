package com.sai.restapi.user_management_system.annotations.project;

import com.sai.restapi.user_management_system.utility.ProjectExamples;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Operation(summary = "Update project by id")
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@io.swagger.v3.oas.annotations.parameters.RequestBody(
        description = "Project create request",
        required = true,
        content = @Content(
                examples = @ExampleObject(
                        name = "User Create Request",
                        value = ProjectExamples.PROJECT_REQUEST
                )
        )
)

@ApiResponses(
        @ApiResponse(responseCode = "200",
                content= @Content(examples = @ExampleObject(
                        name="user_input_1",
                        value = ProjectExamples.PROJECT200))
        ))
public @interface UpdateProjectByIdDoc {
}
