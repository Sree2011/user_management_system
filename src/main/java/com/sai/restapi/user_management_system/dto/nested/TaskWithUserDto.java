package com.sai.restapi.user_management_system.dto.nested;

import com.sai.restapi.user_management_system.dto.individual.UserDTO;
import com.sai.restapi.user_management_system.utility.Priority;
import com.sai.restapi.user_management_system.utility.Status;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskWithUserDto {
        private Integer taskId;
        private String title;
        private String description;
        private Status status;
        private Priority priority;
        private UserDTO assignedTo;
}
