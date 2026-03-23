package com.sai.restapi.user_management_system.dto.individual;

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
}