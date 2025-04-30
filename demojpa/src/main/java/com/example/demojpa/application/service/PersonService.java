package com.example.demojpa.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demojpa.domain.Person;
import com.example.demojpa.domain.Rol;


@Service
public interface PersonService {
    public List<Person> findAllUsersByFilter(String filter, String value);
    public List<Rol> findAllRolesByFilter(String filter, String value);
}
