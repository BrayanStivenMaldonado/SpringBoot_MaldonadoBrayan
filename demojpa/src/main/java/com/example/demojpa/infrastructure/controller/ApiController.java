package com.example.demojpa.infrastructure.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpa.application.service.PersonService;
import com.example.demojpa.application.service.ProjectService;
import com.example.demojpa.domain.Person;
import com.example.demojpa.domain.Project;
import com.example.demojpa.domain.Rol;
import com.example.demojpa.domain.RoleRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE) //ruta base de todos los metodos que definamos (api/usuarios).
public class ApiController {

    private final PersonService personService;
    private final ProjectService projectService;

    public ApiController(PersonService personService, ProjectService projectService){
        this.personService = personService;
        this.projectService = projectService;
    }

    @GetMapping("/users")
    public List<Person> findAll(
        @RequestParam(name = "filter", defaultValue = "") String filter,
        @RequestParam(name = "value", defaultValue = "") String value 
    ){
        List<Person> results = personService.findAllUsersByFilter(filter, value);

        return results;
    }    

    @GetMapping("/roles")
    public List<Rol> findAllRoles(
        @RequestParam(name = "filter", defaultValue = "") String filter,
        @RequestParam(name = "value", defaultValue = "") String value 
    ){
        List<Rol> results = personService.findAllRolesByFilter(filter, value);

        return results;
    }   


    @PostMapping("/roles")    
    public Map<String, Object> newRole(@RequestBody RoleRequest role){
        return Map.of("ID", role.getId(), "NAME", role.getName());
    }

    @GetMapping("/projects")
    public List<Project> findAllProjects(
        @RequestParam(name = "filter", defaultValue = "") String filter,
        @RequestParam(name = "value", defaultValue = "") String value 
    ){
        List<Project> results = projectService.findAllProjects();

        return results;
    } 
}
