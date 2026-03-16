package com.sai.restapi.user_management_system.controller.nested;

import com.sai.restapi.user_management_system.annotations.ServerErrorDoc;
import com.sai.restapi.user_management_system.annotations.userwithproject.AssignProjectToUserDoc;
import com.sai.restapi.user_management_system.annotations.userwithproject.GetAllUsersAssignedToProjectsDoc;
import com.sai.restapi.user_management_system.annotations.userwithproject.GetUserWithProjectsDoc;
import com.sai.restapi.user_management_system.dto.nested.UserWithProjectsDTO;
import com.sai.restapi.user_management_system.service.nested.UserWithProjectService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userwithprojects")
@ServerErrorDoc
@Tag(name = "6. User With Project Controller", description = "Handles operations common to user and project")
public class UserWithProjectController {

    private final UserWithProjectService upService;

    public UserWithProjectController(UserWithProjectService userService){
        this.upService = userService;
    }

    @GetMapping("/getbyuser")
    @GetUserWithProjectsDoc
    public ResponseEntity<UserWithProjectsDTO> getUserWithProjects(@RequestParam Integer userId){
        UserWithProjectsDTO pu1 = upService.getUserWithProjects(userId);
        return ResponseEntity.ok(pu1);
    }

    @PostMapping("/create")
    @AssignProjectToUserDoc
    public ResponseEntity<UserWithProjectsDTO> assignProjectToUser(@RequestParam Integer projectId, @RequestParam Integer userId){
        UserWithProjectsDTO pu2 = upService.assignProjectToUser(projectId,userId);
        return ResponseEntity.ok(pu2);
    }


    @GetMapping("/getallusers")
    @GetAllUsersAssignedToProjectsDoc
    public ResponseEntity<List<UserWithProjectsDTO>> getAllUsersAndProjects() {
        List<UserWithProjectsDTO> upDto = upService.getAllUsersAndProjects();
        return ResponseEntity.ok(upDto);
    }







}
