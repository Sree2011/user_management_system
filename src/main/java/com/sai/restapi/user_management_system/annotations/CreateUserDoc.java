package com.sai.restapi.user_management_system.annotations;

import com.sai.restapi.user_management_system.enums.SwaggerExamples;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Operation(summary = "Create a new user")
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@io.swagger.v3.oas.annotations.parameters.RequestBody(
        description = "User create request",
        required = true,
        content = @Content(
                examples = @ExampleObject(
                        name = "User Create Request",
                        value = SwaggerExamples.USER_REQUEST
                )
        )
)

@ApiResponses(
        @ApiResponse(responseCode = "200",
                content= @Content(examples = @ExampleObject(
                        name="user_input_1",
                        value = SwaggerExamples.USER200))
        ))
public @interface CreateUserDoc {
}
