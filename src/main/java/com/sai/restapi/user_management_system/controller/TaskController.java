package com.sai.restapi.user_management_system.controller;

import com.sai.restapi.user_management_system.annotations.ServerErrorDoc;
import com.sai.restapi.user_management_system.annotations.task.*;
import com.sai.restapi.user_management_system.dto.TaskDTO;
import com.sai.restapi.user_management_system.exception.TaskNotFoundException;
import com.sai.restapi.user_management_system.service.TaskService;
import com.sai.restapi.user_management_system.utility.DeleteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@ServerErrorDoc
@Tag(name = "Task Management Controller", description = "Handles operations on tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    //----------------------------Get Tasks---------------------------------
    @GetMapping("/getall")
    @GetAllTasksDoc
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> tasks = service.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/getbyid")
    @Operation(summary = "Get Task by id")
    @GetTaskbyIdDoc
    public ResponseEntity<TaskDTO> getTaskById(@RequestParam Integer taskId) throws TaskNotFoundException {
        TaskDTO task = service.getTaskById(taskId);
        return ResponseEntity.ok(task);
    }

    //------------------------------Create Task------------------------------
    @PostMapping("/create")
    @CreateTaskDoc
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        TaskDTO createdTask = service.createTask(taskDTO);
        return ResponseEntity.ok(createdTask);
    }

    //------------------------------Update Task by id--------------------
    @PatchMapping("/update")
    @UpdateTaskByIdDoc
    public ResponseEntity<TaskDTO> updateTaskById(@RequestBody TaskDTO updatedTask, @RequestParam Integer id)
            throws TaskNotFoundException {
        TaskDTO existingTask = service.updateTaskById(updatedTask, id);
        return ResponseEntity.ok(existingTask);
    }

    //------------------------Delete Task by id-------------------------
    @DeleteMapping("/deletebyid")
    @DeleteTaskByIdDoc
    public ResponseEntity<DeleteResponse> deleteTaskById(@RequestParam Integer id) throws TaskNotFoundException {
        service.deleteTaskById(id);
        return ResponseEntity.ok(new DeleteResponse("204", "Task deleted successfully"));
    }
}