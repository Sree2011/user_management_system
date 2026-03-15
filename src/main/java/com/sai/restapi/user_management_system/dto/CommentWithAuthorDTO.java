package com.sai.restapi.user_management_system.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentWithAuthorDTO {
    private Integer commentId;
    private String content;
    private UserDTO author;  // nested DTO instead of just authorId
}