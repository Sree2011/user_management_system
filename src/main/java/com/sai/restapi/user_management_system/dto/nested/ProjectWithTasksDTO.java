package com.sai.restapi.user_management_system.dto.nested;

import com.sai.restapi.user_management_system.dto.individual.TaskDTO;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectWithTasksDTO {
    private Integer projectId;
    private String name;
    private String description;
    private List<TaskDTO> tasks;  // nested DTOs
}