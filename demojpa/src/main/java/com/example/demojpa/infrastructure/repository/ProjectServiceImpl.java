package com.example.demojpa.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demojpa.application.service.ProjectService;
import com.example.demojpa.domain.Project;

@Service
public class ProjectServiceImpl implements ProjectService {
    
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAllProjects(){
        return projectRepository.findAll();
    }
}
