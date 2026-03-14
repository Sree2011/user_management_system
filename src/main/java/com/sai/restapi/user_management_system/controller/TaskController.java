package com.sai.restapi.user_management_system.controller;

import com.sai.restapi.user_management_system.annotations.ServerErrorDoc;
import com.sai.restapi.user_management_system.annotations.task.*;
import com.sai.restapi.user_management_system.annotations.user.*;
import com.sai.restapi.user_management_system.exception.TaskNotFoundException;
import com.sai.restapi.user_management_system.model.Task;

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

        //----------------------------Get Users---------------------------------
        @GetMapping("/getall")

        @GetAllTasksDoc
        public ResponseEntity<List<Task>> getAllTasks(){
            List<Task> ss = service.getAllTasks();
            return ResponseEntity.ok(ss);
        }

        @GetMapping("/getbyid")
        @Operation(summary="Get Tasks by id")
        @GetTaskbyIdDoc
        public ResponseEntity<Task> getTaskById(@RequestParam Integer taskId) throws TaskNotFoundException {
            Task task = service.getTaskById(taskId);
            return ResponseEntity.ok(task);
        }


        //------------------------------Create Users------------------------------
        @PostMapping("/create")
        @CreateTaskDoc
        public ResponseEntity<Task> createTask(@RequestBody Task task){
            Task task1 = service.createTask(task);
            return ResponseEntity.ok(task1);
        }


        //------------------------------Update user by id--------------------
        @PatchMapping("/update")
        @UpdateTaskByIdDoc
        public ResponseEntity<Task> updateUserById(@RequestBody Task updatedTask,  @RequestParam Integer id) throws TaskNotFoundException{
            Task existingTask = service.updateTaskById(updatedTask, id);
            return ResponseEntity.ok(existingTask);
        }


        //------------------------Delete user by id-------------------------
        @DeleteMapping("/deletebyid")
        @DeleteTaskByIdDoc
        public ResponseEntity<DeleteResponse> deleteUserById(@RequestParam Integer id) throws TaskNotFoundException{
            service.deleteTaskById(id);
            return ResponseEntity.ok(new DeleteResponse("204","Task deleted successfully"));
        }


    }


