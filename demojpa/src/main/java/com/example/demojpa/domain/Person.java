package com.example.demojpa.domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//Aplicado a JPA

//Bidireccional
//ManyToOne
//OneToMany
//OneToOne
//ManyToMany (Llaves compuestas)
//Embeddable - ¿Qué son y cuándo usarlas?

@Entity
@Table(name = "person")
@EqualsAndHashCode(exclude = {"role"})
@ToString(exclude = {"role"})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "first_name", columnDefinition = "TEXT", length = 50, nullable = false)
    private String name;
    private String lastName;

    @Column(name = "ProgrammingLanguage") 
    private String language;

    @ManyToOne(cascade = CascadeType.ALL) //Nivel de JPA
    @JoinColumn(name = "Rol_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) //Nivel de base de datos
    @JsonBackReference //Marca el lado que no se serializa
    private Rol role;

    @OneToOne(mappedBy = "person")
    private Passport passport;
    //private List<Passport> passports = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "persons_projects",
        joinColumns = @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "fk_person")),
        inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    @JsonBackReference
    private List<Project> projects = new ArrayList<>();

    public Person() {
    }

    public Person(Long id, String name, String lastName, String language) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Rol getRole() {
        return role;
    }

    public void setRole(Rol role) {
        this.role = role;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }    
}