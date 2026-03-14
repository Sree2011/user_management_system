package com.sai.restapi.user_management_system.annotations.comment;

import com.sai.restapi.user_management_system.utility.CommentExamples;
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
@Operation(summary = "Get All Comments")
@ApiResponse(
        description = "Comments Retrieved successfully",
        content = @Content(
                examples = @ExampleObject(name="List of Comments", value = CommentExamples.LIST_COMMENTS)
        )
)
public @interface GetAllCommentsDoc {
}
