package com.sai.restapi.user_management_system.controller;

import com.sai.restapi.user_management_system.annotations.project.*;
import com.sai.restapi.user_management_system.annotations.ServerErrorDoc;
import com.sai.restapi.user_management_system.annotations.project.UpdateProjectByIdDoc;
import com.sai.restapi.user_management_system.exception.ProjectNotFoundException;
import com.sai.restapi.user_management_system.model.Project;
import com.sai.restapi.user_management_system.service.ProjectService;
import com.sai.restapi.user_management_system.utility.DeleteResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ServerErrorDoc
@Tag(name = "Project Management Controller", description = "Manages operations on projects")
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    //---------------Create project------------------
    @PostMapping("/create")
    @CreateProjectDoc
    public ResponseEntity<Project> CreateProject(@RequestBody Project project){
        Project project1 = projectService.createProject(project);
        return ResponseEntity.ok(project1);
    }

    //----------------Get All Projects------------------
    @GetMapping("/getall")
    @GetAllProjectDoc
    public ResponseEntity<List<Project>> getAllProjects(){
        List<Project> list = projectService.getAllProjects();
        return ResponseEntity.ok(list);
    }

    //-----------Get Project by id---------------------
    @GetMapping("/getbyid")
    @GetProjectByIdDoc
    public ResponseEntity<Project> getProjectById(@RequestParam Integer id) throws ProjectNotFoundException{
        Project list = projectService.getProjectById(id);
        return ResponseEntity.ok(list);
    }


    //-----------Update project by id---------------------
    @PatchMapping("/update")
    @UpdateProjectByIdDoc
    public ResponseEntity<Project> updateProjectById(@RequestBody Project project,@RequestParam Integer id) throws ProjectNotFoundException{
        Project list = projectService.updateProjectById(project,id);
        return ResponseEntity.ok(list);
    }

    //--------Delete Project By Id-------------------
    @DeleteMapping("/delete")
    @DeleteProjectDoc
    public ResponseEntity<DeleteResponse> deleteProjectById(@RequestParam Integer id) throws ProjectNotFoundException{
        projectService.deleteProjectById(id);
        return ResponseEntity.ok(new DeleteResponse("204", "Project Deleted Successfully"));

    }



}
