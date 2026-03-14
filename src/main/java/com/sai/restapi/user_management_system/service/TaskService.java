package com.sai.restapi.user_management_system.service;

import com.sai.restapi.user_management_system.dto.TaskDTO;
import com.sai.restapi.user_management_system.exception.TaskNotFoundException;
import com.sai.restapi.user_management_system.model.Task;
import com.sai.restapi.user_management_system.repository.TaskRepository;
import com.sai.restapi.user_management_system.utility.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //---------------Create a task-----------------
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        // enums are stored as strings in DTO
        if (taskDTO.getStatus() != null) {
            task.setStatus(Enum.valueOf(com.sai.restapi.user_management_system.utility.Status.class, taskDTO.getStatus()));
        }
        if (taskDTO.getPriority() != null) {
            task.setPriority(Enum.valueOf(com.sai.restapi.user_management_system.utility.Priority.class, taskDTO.getPriority()));
        }
        Task savedTask = taskRepository.save(task);
        return DtoMapper.toTaskDTO(savedTask);
    }

    //-------------------Get All tasks----------------
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(DtoMapper::toTaskDTO)
                .collect(Collectors.toList());
    }

    //-----------Get task by id----------------
    public TaskDTO getTaskById(Integer id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        return DtoMapper.toTaskDTO(task);
    }

    //------------Update task by id--------------
    public TaskDTO updateTaskById(TaskDTO taskDTO, Integer id) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        existingTask.setTitle(taskDTO.getTitle());
        existingTask.setDescription(taskDTO.getDescription());
        if (taskDTO.getStatus() != null) {
            existingTask.setStatus(Enum.valueOf(com.sai.restapi.user_management_system.utility.Status.class, taskDTO.getStatus()));
        }
        if (taskDTO.getPriority() != null) {
            existingTask.setPriority(Enum.valueOf(com.sai.restapi.user_management_system.utility.Priority.class, taskDTO.getPriority()));
        }

        Task updatedTask = taskRepository.save(existingTask);
        return DtoMapper.toTaskDTO(updatedTask);
    }

    //----------------Delete task by id--------------
    public void deleteTaskById(Integer id) throws TaskNotFoundException {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }
}