package com.sai.restapi.user_management_system.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentDTO {
    private Integer commentId;
    private String content;
    private LocalDateTime createdAt;
    private Integer taskId;    // instead of full Task entity
    private Integer authorId;  // instead of full User entity
}