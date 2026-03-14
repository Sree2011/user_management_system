package com.sai.restapi.user_management_system.service;

import com.sai.restapi.user_management_system.exception.ProjectNotFoundException;

import com.sai.restapi.user_management_system.model.Project;
import com.sai.restapi.user_management_system.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository repository) {
        this.projectRepository = repository;
    }


    //------------------Get all projects-------------------
    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }



    //----------Get Project by Id---------------------
    public Project getProjectById(Integer id) throws ProjectNotFoundException{
        return projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
    }



    //---------------Create Project----------------------
    public Project createProject(Project project){
        return projectRepository.save(project);
    }


    //-----------------Update project by id-----------------
    public Project updateProjectById(Project updatedProject, Integer id) throws ProjectNotFoundException{
        Project existingproject = projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id) );
        existingproject.setName(updatedProject.getName());
        existingproject.setDescription(updatedProject.getDescription());
        return projectRepository.save(existingproject);
    }


    //------------Delete project by id---------------------
    public void deleteProjectById(Integer id){
        projectRepository.deleteById(id);
    }





}
