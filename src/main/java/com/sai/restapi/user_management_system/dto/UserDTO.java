package com.sai.restapi.user_management_system.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private Integer userId;
    private String name;
    private String email;
    private List<Integer> projectIds;  // instead of full Project list
    private List<Integer> taskIds;     // instead of full Task list
    private List<Integer> commentIds;  // instead of full Comment list
}