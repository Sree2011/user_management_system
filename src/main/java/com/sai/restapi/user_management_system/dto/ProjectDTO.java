
package com.sai.restapi.user_management_system.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectDTO {
        private Integer projectId;
        private String name;
        private String description;
        private LocalDateTime createdAt;
        private Integer ownerId;        // instead of full User entity
        private List<Integer> taskIds;  // instead of full Task list
}

