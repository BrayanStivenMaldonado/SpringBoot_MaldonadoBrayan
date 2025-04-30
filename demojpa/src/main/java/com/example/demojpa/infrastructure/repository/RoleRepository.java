package com.example.demojpa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demojpa.domain.Rol;

public interface RoleRepository extends JpaRepository<Rol, Long>{
    
}
