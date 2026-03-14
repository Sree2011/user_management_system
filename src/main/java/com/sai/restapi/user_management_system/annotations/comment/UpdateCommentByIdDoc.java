package com.sai.restapi.user_management_system.annotations.comment;

import com.sai.restapi.user_management_system.utility.CommentExamples;
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
@Operation(summary = "Update comment by Id")
@RequestBody(description = "Update comment request",
        content = @Content(
                examples = @ExampleObject(name = "Comment request", value = CommentExamples.COMMENT_REQUEST)))
@ApiResponse(
        description = "Update comment",
        content = @Content(
                examples = @ExampleObject(name="Created comment", value = CommentExamples.COMMENT200)
        )
)
public @interface UpdateCommentByIdDoc {
}
