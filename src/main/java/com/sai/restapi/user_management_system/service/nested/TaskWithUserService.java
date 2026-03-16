package com.sai.restapi.user_management_system.service.nested;

import com.sai.restapi.user_management_system.dto.nested.TaskWithUserDto;
import com.sai.restapi.user_management_system.dto.nested.UserWithProjectsDTO;
import com.sai.restapi.user_management_system.model.Task;
import com.sai.restapi.user_management_system.model.User;

import com.sai.restapi.user_management_system.repository.individual.TaskRepository;
import com.sai.restapi.user_management_system.repository.nested.TaskWithUserRepo;
import com.sai.restapi.user_management_system.utility.NestedDtoMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class TaskWithUserService{

    private final TaskWithUserRepo taskWithUserRepo;
    private final TaskRepository taskRepository;

    public TaskWithUserService(TaskWithUserRepo taskWithUserRepo,
                               TaskRepository taskRepository) {
        this.taskWithUserRepo = taskWithUserRepo;
        this.taskRepository = taskRepository;
    }

    public List<TaskWithUserDto> findAllTasksForUser(Integer userId){
            List<Task> task3 = taskWithUserRepo.findAllTasksForUser(userId);
            ArrayList<TaskWithUserDto> userTask = new ArrayList<>();
            for(Task task : task3){
                userTask.add(NestedDtoMapper.toTaskWithUserDTO(task));
            }
            return userTask;
    }

    public TaskWithUserDto assignTaskToUser(Integer taskId, User user) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        task.setUser(user);
        Task updated = taskRepository.save(task);
        return NestedDtoMapper.toTaskWithUserDTO(updated);
    }

    public List<TaskWithUserDto> getAllUsersAndTasks() {
        List<Task> tasks = taskWithUserRepo.getAllUsersAndTasks();
        return tasks.stream()
                .map(NestedDtoMapper::toTaskWithUserDTO)
                .toList();
    }


}