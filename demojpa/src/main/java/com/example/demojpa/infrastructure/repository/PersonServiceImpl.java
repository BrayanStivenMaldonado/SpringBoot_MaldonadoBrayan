package com.example.demojpa.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demojpa.application.service.PersonService;
import com.example.demojpa.domain.Person;
import com.example.demojpa.domain.Rol;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;

    public PersonServiceImpl(PersonRepository personRepository, RoleRepository roleRepository){
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
    }

     @Override
     public List<Person> findAllUsersByFilter(String filter, String value) {
        if(filter.toLowerCase().equals("name") && !value.isEmpty()){
            return personRepository.findByNameContains(value);
         }else if(filter.toLowerCase().equals("languaje") && !value.isEmpty()){
             return personRepository.findByLanguageEquals(value);
         }else{
             return personRepository.findAll();
         }
    }

     @Override
     public List<Rol> findAllRolesByFilter(String filter, String value) {
        return roleRepository.findAll();
     }


}
