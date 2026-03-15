package com.sai.restapi.user_management_system.dto;

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