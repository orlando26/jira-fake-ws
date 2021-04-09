package com.jirafake.api.repository;

import com.jirafake.api.entity.Project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer>{
    
}
