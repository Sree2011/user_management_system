package com.sai.restapi.user_management_system.controller;

import com.sai.restapi.user_management_system.dto.UserWithProjectsDTO;
import com.sai.restapi.user_management_system.service.UserWithProjectService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userwithprojects")
@Tag(name = "6. User With Project Controller", description = "Handles operations common to user and project")
public class UserWithProjectController {

    private final UserWithProjectService upService;

    public UserWithProjectController(UserWithProjectService userService){
        this.upService = userService;
    }

    @GetMapping("/getall")
    public ResponseEntity<UserWithProjectsDTO> getUserWithProjects(@RequestParam Integer userId){
        UserWithProjectsDTO pu1 = upService.getUserWithProjects(userId);
        return ResponseEntity.ok(pu1);
    }

    @PostMapping("/create")
    public ResponseEntity<UserWithProjectsDTO> assignProjectToUser(@RequestParam Integer projectId, @RequestParam Integer userId){
        UserWithProjectsDTO pu2 = upService.assignProjectToUser(projectId,userId);
        return ResponseEntity.ok(pu2);
    }






}
