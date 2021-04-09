package com.jirafake.api.repository;

import com.jirafake.api.entity.Status;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer>{
    
}
