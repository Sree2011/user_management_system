package com.sai.restapi.user_management_system.dto.nested;

import com.sai.restapi.user_management_system.dto.individual.ProjectDTO;
import com.sai.restapi.user_management_system.model.Project;
import com.sai.restapi.user_management_system.model.User;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserWithProjectsDTO {
    private Integer userId;
    private String name;
    private String email;
    private List<ProjectDTO> projects;  // nested DTOs instead of IDs


}