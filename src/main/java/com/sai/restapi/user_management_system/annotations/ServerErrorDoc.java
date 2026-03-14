package com.sai.restapi.user_management_system.annotations;

import com.sai.restapi.user_management_system.utility.UserExamples;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(

                value = {
                        @ApiResponse(responseCode = "500",
                        description = "Internal Server Error",
                        content = @Content(examples = @ExampleObject(name = "500 error", value = UserExamples.USER500))),

                        @ApiResponse(responseCode = "404",
                                description = "User Not Found",
                                content = @Content(examples = @ExampleObject(name = "404 example", value = UserExamples.USER404)))
                }
)
public @interface ServerErrorDoc {
}
