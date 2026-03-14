package com.sai.restapi.user_management_system.annotations.project;

import com.sai.restapi.user_management_system.utility.ProjectExamples;
import com.sai.restapi.user_management_system.utility.UserExamples;
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
@Operation(summary = "Delete Project by id")
@ApiResponse(responseCode = "204",description = "Successfully deleted",
        content = @Content(examples = {@ExampleObject(name = "PROJECT204", value= ProjectExamples.PROJECT204)}))
public @interface DeleteProjectDoc {
}
