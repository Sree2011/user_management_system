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

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "Successfully retrieved list of users",
                content = @Content(
                        examples = @ExampleObject(
                                name = "user_list_example",
                                value = SwaggerExamples.USER200
                        )
                )
        )
})
public @interface GetAllUserDoc {
}