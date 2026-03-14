package com.sai.restapi.user_management_system.service;

import com.sai.restapi.user_management_system.exception.TaskNotFoundException;
import com.sai.restapi.user_management_system.model.Task;
import com.sai.restapi.user_management_system.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //---------------Create a task-----------------
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    //-------------------Get All tasks----------------
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    //-----------Get task by id----------------
    public Task getTaskById(Integer id){
        return taskRepository.findById(id).orElseThrow(() ->new TaskNotFoundException(id));
    }


    //------------Update task by id--------------
    public Task updateTaskById(Task task, Integer id){
        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());

        return taskRepository.save(existingTask);

    }


    //----------------Delete task by id--------------
    public void deleteTaskById(Integer id) throws TaskNotFoundException{
        if(!taskRepository.existsById(id)){
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }
}
