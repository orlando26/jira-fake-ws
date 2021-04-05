package com.jirafake.api.repository;

import com.jirafake.api.entity.Type;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Integer> {
    
}
