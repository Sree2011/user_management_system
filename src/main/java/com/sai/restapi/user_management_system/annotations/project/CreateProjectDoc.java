package com.sai.restapi.user_management_system.annotations.project;

import com.sai.restapi.user_management_system.utility.ProjectExamples;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "Create a project")
@ApiResponse(responseCode = "200", content = @Content(examples = @ExampleObject(name= "create project", value= ProjectExamples.PROJECT200)))
@RequestBody(content = @Content(examples = {@ExampleObject(name="project create request",value= ProjectExamples.PROJECT_REQUEST)}))
public @interface CreateProjectDoc {
}
