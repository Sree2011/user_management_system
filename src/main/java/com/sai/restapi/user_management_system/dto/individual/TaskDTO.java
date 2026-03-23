package com.sai.restapi.user_management_system.dto.individual;

import lombok.*;
import java.util.List;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskDTO {
    private Integer taskId;
    private String title;
    private String description;
    private String status;       // flattened from Status enum
    private String priority;     // flattened from Priority enum

}