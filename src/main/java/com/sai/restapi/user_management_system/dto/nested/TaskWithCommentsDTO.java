package com.sai.restapi.user_management_system.dto.nested;

import com.sai.restapi.user_management_system.dto.individual.CommentDTO;
import com.sai.restapi.user_management_system.utility.Priority;
import com.sai.restapi.user_management_system.utility.Status;
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
    private List<CommentDTO> comments;  // nested DTOs
}