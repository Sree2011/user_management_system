package com.sai.restapi.user_management_system.utility;

import com.sai.restapi.user_management_system.dto.individual.CommentDTO;
import com.sai.restapi.user_management_system.dto.individual.ProjectDTO;
import com.sai.restapi.user_management_system.dto.individual.TaskDTO;
import com.sai.restapi.user_management_system.dto.individual.UserDTO;
import com.sai.restapi.user_management_system.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class DtoMapper {

    // -------------------- User --------------------
    public static UserDTO toUserDTO(User user) {
        if (user == null) return null;
        return new UserDTO(
                user.getUser_id(),
                user.getName(),
                user.getEmail()
        );
    }

    // -------------------- Project --------------------
    public static ProjectDTO toProjectDTO(Project project) {
        if (project == null) return null;
        return new ProjectDTO(
                project.getProjectId(),
                project.getName(),
                project.getDescription()
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
                task.getPriority() != null ? task.getPriority().name() : null
        );
    }

    // -------------------- Comment --------------------
    public static CommentDTO toCommentDTO(Comment comment) {
        if (comment == null) return null;
        return new CommentDTO(
                comment.getComment_id(),
                comment.getContent()
                //comment.getTask() != null ? comment.getTask().getTask_id() : null
                //comment.getAuthor() != null ? comment.getAuthor().getUser_id() : null
        );
    }
}