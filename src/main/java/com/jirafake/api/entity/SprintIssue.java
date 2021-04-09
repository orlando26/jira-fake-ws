package com.jirafake.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "sprint_issue")
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SprintIssue {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private Integer id;

    @Column(name = "sprint_id")
    private Integer sprintId;

    @Column(name = "issue_id")
    private Integer issueId;

    @Builder
    public SprintIssue(Integer id, Integer sprintId, Integer issueId) {
        this.id = id;
        this.sprintId = sprintId;
        this.issueId = issueId;
    }



}
