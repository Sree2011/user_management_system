package com.sai.restapi.user_management_system.dto;

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