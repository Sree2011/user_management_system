package com.sai.restapi.user_management_system.service.nested;


import com.sai.restapi.user_management_system.dto.nested.TaskWithCommentsDTO;
import com.sai.restapi.user_management_system.exception.CommentNotFoundException;
import com.sai.restapi.user_management_system.exception.TaskNotFoundException;
import com.sai.restapi.user_management_system.model.Comment;
import com.sai.restapi.user_management_system.model.Task;
import com.sai.restapi.user_management_system.repository.individual.CommentRepository;
import com.sai.restapi.user_management_system.repository.individual.TaskRepository;
import com.sai.restapi.user_management_system.repository.nested.TaskWithCommentRepo;
import com.sai.restapi.user_management_system.utility.DtoMapper;
import com.sai.restapi.user_management_system.utility.NestedDtoMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskWithCommentService {

    private final TaskWithCommentRepo taskWithCommentRepo;
    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;

    public TaskWithCommentService(TaskWithCommentRepo taskWithCommentRepo,
                                  TaskRepository taskRepository,
                                  CommentRepository commentRepository) {
        this.taskWithCommentRepo = taskWithCommentRepo;
        this.taskRepository = taskRepository;
        this.commentRepository = commentRepository;
    }

    public List<TaskWithCommentsDTO> findCommentsForTask(Integer taskId) {
        // Fetch the task itself
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task == null) return List.of();

        // Fetch all comments for the given task
        List<Comment> comments = taskWithCommentRepo.findAllCommentsForTask(taskId);

        // Attach comments to the task entity (if not already loaded)
        task.setComments(comments);

        // Map task + comments into DTO using centralized mapper
        TaskWithCommentsDTO dto = NestedDtoMapper.toTaskWithCommentsDTO(task);

        return List.of(dto);
    }


    public List<TaskWithCommentsDTO> getAllTasksAndComments() {
        // Fetch all tasks with their comments
        List<Task> tasks = taskWithCommentRepo.getAllTasksAndComments();

        // Map each Task entity into a TaskWithCommentsDTO
        List<TaskWithCommentsDTO> dtolist = new ArrayList<>();

        for (Task task : tasks) {
            dtolist.add(NestedDtoMapper.toTaskWithCommentsDTO(task));
        }

        return dtolist;
    }

    public TaskWithCommentsDTO assignCommentToTask(Integer taskId, List<Integer> commentIds){
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));

        List<Comment> comments = new ArrayList<>();

        for(Integer i : commentIds){
            Comment comment = commentRepository.findById(i).orElseThrow(()-> new CommentNotFoundException(i));
            comment.setTask(task);
            comments.add(comment);
        }

        task.setComments(comments);

        return NestedDtoMapper.toTaskWithCommentsDTO(task);


    }

}
