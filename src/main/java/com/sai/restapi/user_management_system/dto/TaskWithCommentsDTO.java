package com.sai.restapi.user_management_system.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskWithCommentsDTO {
    private Integer taskId;
    private String title;
    private String description;
    private String status;
    private String priority;
    private Integer projectId;
    private Integer assignedTo;
    private List<CommentDTO> comments;  // nested DTOs
}