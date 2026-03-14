package com.sai.restapi.user_management_system.annotations.project;

import com.sai.restapi.user_management_system.utility.ProjectExamples;
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
@Operation(summary = "Get project by Id")
@ApiResponse(responseCode = "200", content =
@Content(examples = @ExampleObject(name="Get project by id",value = ProjectExamples.PROJECT200)))
public @interface GetProjectByIdDoc {
}
