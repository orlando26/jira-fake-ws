package com.jirafake.api.repository;

import com.jirafake.api.entity.Priority;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepository extends JpaRepository<Priority, Integer>{
    
}
