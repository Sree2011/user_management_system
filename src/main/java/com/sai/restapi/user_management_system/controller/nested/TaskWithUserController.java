package com.sai.restapi.user_management_system.controller.nested;

import com.sai.restapi.user_management_system.annotations.taskwithuser.AssignTaskToUserDoc;
import com.sai.restapi.user_management_system.annotations.taskwithuser.GetAllTasksForUserDoc;
import com.sai.restapi.user_management_system.annotations.taskwithuser.GetAllTasksWithUserDoc;
import com.sai.restapi.user_management_system.dto.nested.TaskWithUserDto;
import com.sai.restapi.user_management_system.exception.UserNotFoundException;
import com.sai.restapi.user_management_system.model.Task;
import com.sai.restapi.user_management_system.model.User;
import com.sai.restapi.user_management_system.repository.individual.UserRepository;
import com.sai.restapi.user_management_system.service.nested.TaskWithUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    @GetMapping("/getbyuser")
    @GetAllTasksForUserDoc
    public ResponseEntity<List<TaskWithUserDto>> getAllTasksForAUser(@RequestParam Integer userId){
        List<TaskWithUserDto> list1 = taskWithUserService.findAllTasksForUser(userId);
        return ResponseEntity.ok(list1);
    }



    @PostMapping("/create")
    @AssignTaskToUserDoc
    public ResponseEntity<TaskWithUserDto> assignTaskToUser(@RequestParam Integer taskId, @RequestParam Integer userId) throws UserNotFoundException{
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        TaskWithUserDto ttd = taskWithUserService.assignTaskToUser(taskId, user);
        return ResponseEntity.ok(ttd);
    }

    @GetMapping("/getallusers")
    @GetAllTasksWithUserDoc
    public ResponseEntity<List<TaskWithUserDto>> getAllUsersAndTasks(){
        List<TaskWithUserDto> tasklist = taskWithUserService.getAllUsersAndTasks();
        return ResponseEntity.ok(tasklist);
    }

}
