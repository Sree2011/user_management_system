package com.sai.restapi.user_management_system.controller.nested;

import com.sai.restapi.user_management_system.dto.nested.TaskWithCommentsDTO;
import com.sai.restapi.user_management_system.service.nested.TaskWithCommentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name="8. Task With Comment Controller", description = "Handles operations common to task and comment")
@RequestMapping("/taskwithcomment")
public class TaskWithCommentsController {

    private final TaskWithCommentService taskWithCommentService;

    public TaskWithCommentsController(TaskWithCommentService taskWithCommentService) {
        this.taskWithCommentService = taskWithCommentService;
    }

    @PostMapping("/assigncommenttotask")
    public ResponseEntity<TaskWithCommentsDTO> assignCommentToTask(
            @RequestParam Integer taskId,
            @RequestBody List<Integer> comments) {

        TaskWithCommentsDTO dto = taskWithCommentService.assignCommentToTask(taskId, comments);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<TaskWithCommentsDTO>> getAllTasksAndComments(){
        List<TaskWithCommentsDTO> dtolist = taskWithCommentService.getAllTasksAndComments();
        return ResponseEntity.ok(dtolist);
    }
}
