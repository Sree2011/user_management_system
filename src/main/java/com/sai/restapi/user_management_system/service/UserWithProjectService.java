package com.sai.restapi.user_management_system.service;

import com.sai.restapi.user_management_system.dto.UserWithProjectsDTO;
import com.sai.restapi.user_management_system.model.Project;
import com.sai.restapi.user_management_system.model.User;
import com.sai.restapi.user_management_system.repository.ProjectRepository;
import com.sai.restapi.user_management_system.repository.UserRepository;
import com.sai.restapi.user_management_system.repository.UserWithProjectsRepo;
import com.sai.restapi.user_management_system.utility.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserWithProjectService {

    @Autowired
    private UserWithProjectsRepo userWithProjectsRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProjectRepository projectRepo;

    // Get all projects for a user
    public UserWithProjectsDTO getUserWithProjects(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow();
        List<Project> projects = userWithProjectsRepo.getAllProjectsForUser(userId);

        return new UserWithProjectsDTO(
                user.getUser_id(),
                user.getName(),
                user.getEmail(),
                projects.stream()
                        .map(DtoMapper::toProjectDTO)
                        .toList()
        );
    }

    // Assign a project to a user
    public UserWithProjectsDTO assignProjectToUser(Integer projectId, Integer userId) {
        Project project = projectRepo.findById(projectId).orElseThrow();
        User user = userRepo.findById(userId).orElseThrow();

        project.setOwner(user);
        projectRepo.save(project);

        // Return updated DTO
        List<Project> projects = userWithProjectsRepo.getAllProjectsForUser(userId);
        return new UserWithProjectsDTO(
                user.getUser_id(),
                user.getName(),
                user.getEmail(),
                projects.stream()
                        .map(DtoMapper::toProjectDTO)
                        .toList()
        );
    }
}