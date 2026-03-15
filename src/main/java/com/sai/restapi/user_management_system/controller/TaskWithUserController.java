package com.sai.restapi.user_management_system.controller;

import com.sai.restapi.user_management_system.dto.TaskWithUserDto;
import com.sai.restapi.user_management_system.exception.UserNotFoundException;
import com.sai.restapi.user_management_system.model.User;
import com.sai.restapi.user_management_system.repository.UserRepository;
import com.sai.restapi.user_management_system.service.TaskWithUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskwithuser")
@Tag(name = "5. Task With User Controller", description = "Handles operations common to task and user")
public class TaskWithUserController {

    private final TaskWithUserService taskWithUserService;
    private final UserRepository userRepository;

    public TaskWithUserController(TaskWithUserService taskWithUserService,
                                  UserRepository userRepository) {
        this.taskWithUserService = taskWithUserService;
        this.userRepository = userRepository;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<TaskWithUserDto>> getAllTasksForAUser(@RequestParam Integer userId){
        List<TaskWithUserDto> list1 = taskWithUserService.findAllTasksForUser(userId);
        return ResponseEntity.ok(list1);
    }

    @PostMapping("/create")
    public ResponseEntity<TaskWithUserDto> assignTaskToUser(@RequestParam Integer taskId, @RequestParam Integer userId) throws UserNotFoundException{
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        TaskWithUserDto ttd = taskWithUserService.assignTaskToUser(taskId, user);
        return ResponseEntity.ok(ttd);
    }

}
