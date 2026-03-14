package com.sai.restapi.user_management_system.utility;

import com.sai.restapi.user_management_system.model.*;
import com.sai.restapi.user_management_system.dto.*;

import java.util.stream.Collectors;

public class DtoMapper {

    // -------------------- User --------------------
    public static UserDTO toUserDTO(User user) {
        if (user == null) return null;
        return new UserDTO(
                user.getUser_id(),
                user.getName(),
                user.getEmail(),
                user.getProjects() != null ? user.getProjects().stream()
                        .map(Project::getProjectId).collect(Collectors.toList()) : null,
                user.getTasks() != null ? user.getTasks().stream()
                        .map(Task::getTask_id).collect(Collectors.toList()) : null,
                user.getComments() != null ? user.getComments().stream()
                        .map(Comment::getComment_id).collect(Collectors.toList()) : null
        );
    }

    // -------------------- Project --------------------
    public static ProjectDTO toProjectDTO(Project project) {
        if (project == null) return null;
        return new ProjectDTO(
                project.getProjectId(),
                project.getName(),
                project.getDescription(),
                null, // createdAt not in entity yet
                project.getOwner() != null ? project.getOwner().getUser_id() : null,
                project.getTasks() != null ? project.getTasks().stream()
                        .map(Task::getTask_id).collect(Collectors.toList()) : null
        );
    }

    // -------------------- Task --------------------
    public static TaskDTO toTaskDTO(Task task) {
        if (task == null) return null;
        return new TaskDTO(
                task.getTask_id(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus() != null ? task.getStatus().name() : null,
                task.getPriority() != null ? task.getPriority().name() : null,
                null, // dueDate not in entity yet
                task.getProject() != null ? task.getProject().getProjectId() : null,
                task.getUser() != null ? task.getUser().getUser_id() : null,
                task.getComments() != null ? task.getComments().stream()
                        .map(Comment::getComment_id).collect(Collectors.toList()) : null
        );
    }

    // -------------------- Comment --------------------
    public static CommentDTO toCommentDTO(Comment comment) {
        if (comment == null) return null;
        return new CommentDTO(
                comment.getComment_id(),
                comment.getContent(),
                null, // createdAt not in entity yet
                comment.getTask() != null ? comment.getTask().getTask_id() : null,
                comment.getAuthor() != null ? comment.getAuthor().getUser_id() : null
        );
    }
}