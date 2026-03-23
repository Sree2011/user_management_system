
package com.sai.restapi.user_management_system.dto.individual;

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
}

