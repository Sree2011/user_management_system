package com.sai.restapi.user_management_system.service.individual;

import com.sai.restapi.user_management_system.dto.individual.ProjectDTO;
import com.sai.restapi.user_management_system.exception.ProjectNotFoundException;
import com.sai.restapi.user_management_system.model.Project;
import com.sai.restapi.user_management_system.repository.individual.ProjectRepository;
import com.sai.restapi.user_management_system.utility.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository repository) {
        this.projectRepository = repository;
    }

    //------------------Get all projects-------------------
    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(DtoMapper::toProjectDTO)
                .collect(Collectors.toList());
    }

    //----------Get Project by Id---------------------
    public ProjectDTO getProjectById(Integer id) throws ProjectNotFoundException {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        return DtoMapper.toProjectDTO(project);
    }

    //---------------Create Project----------------------
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        Project savedProject = projectRepository.save(project);
        return DtoMapper.toProjectDTO(savedProject);
    }

    //-----------------Update project by id-----------------
    public ProjectDTO updateProjectById(ProjectDTO updatedProjectDTO, Integer id) throws ProjectNotFoundException {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));

        existingProject.setName(updatedProjectDTO.getName());
        existingProject.setDescription(updatedProjectDTO.getDescription());

        Project savedProject = projectRepository.save(existingProject);
        return DtoMapper.toProjectDTO(savedProject);
    }

    //------------Delete project by id---------------------
    public void deleteProjectById(Integer id) throws ProjectNotFoundException {
        if (!projectRepository.existsById(id)) {
            throw new ProjectNotFoundException(id);
        }
        projectRepository.deleteById(id);
    }
}