package com.jirafake.api.repository;

import com.jirafake.api.entity.Issue;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Integer>{

}
