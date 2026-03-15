package com.sai.restapi.user_management_system.utility;

import com.sai.restapi.user_management_system.dto.*;
import com.sai.restapi.user_management_system.model.*;

import java.util.stream.Collectors;

public class NestedDtoMapper {

    // -------------------- User with Projects --------------------
    public static UserWithProjectsDTO toUserWithProjectsDTO(User user) {
        if (user == null) return null;
        return new UserWithProjectsDTO(
                user.getUser_id(),
                user.getName(),
                user.getEmail(),
                user.getProjects() != null ? user.getProjects().stream()
                        .map(DtoMapper::toProjectDTO).collect(Collectors.toList()) : null
        );
    }

    // -------------------- Project with Tasks --------------------
    public static ProjectWithTasksDTO toProjectWithTasksDTO(Project project) {
        if (project == null) return null;
        return new ProjectWithTasksDTO(
                project.getProjectId(),
                project.getName(),
                project.getDescription(),
                project.getTasks() != null ? project.getTasks().stream()
                        .map(DtoMapper::toTaskDTO).collect(Collectors.toList()) : null
        );
    }

    // -------------------- Task with Comments --------------------
    // -------------------- Task with Comments --------------------
    public static TaskWithCommentsDTO toTaskWithCommentsDTO(Task task) {
        if (task == null) return null;
        return new TaskWithCommentsDTO(
                task.getTask_id(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority() != null ? Status.valueOf(task.getPriority().name()) : null, // enum → string
                task.getStatus() != null ? Priority.valueOf(task.getStatus().name()) : null,     // enum → string
                task.getComments() != null ? task.getComments().stream()
                        .map(DtoMapper::toCommentDTO).collect(Collectors.toList()) : null
        );
    }
    //------------------Task with User----------------------------
    public static TaskWithUserDto toTaskWithUserDTO(Task task) {
        if (task == null) return null;
        return new TaskWithUserDto(
                task.getTask_id(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getUser() != null ? DtoMapper.toUserDTO(task.getUser()) : null
        );
    }


    // -------------------- Comment with Author --------------------
    public static CommentWithAuthorDTO toCommentWithAuthorDTO(Comment comment) {
        if (comment == null) return null;
        return new CommentWithAuthorDTO(
                comment.getComment_id(),
                comment.getContent(),
                comment.getAuthor() != null ? DtoMapper.toUserDTO(comment.getAuthor()) : null
        );
    }
}