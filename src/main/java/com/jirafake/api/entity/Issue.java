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
@Entity(name = "issue")
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Issue {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Int id;

    @Column(name = "project_id")
    private Int projectId;

    @Column(name = "title")
    private String title;
    
    @Column(name = "type_id")
    private Int typeId;

    @Column(name = "description")
    private String description;

    @Column(name = "priority_id")
    private Int priorityId;

    @Column(name = "status_id")
    private Int statusId;

    @Column(name = "story_points")
    private Int storyPoints;

    @Column(name = "time_estimate")
    private Int timeEstimate;

    @Column(name = "time_spent")
    private Int timeSpent;

    @Column(name = "reporter_id")
    private Int reporterId;

    @Column(name = "owner_id")
    private Int ownerId;

    @Column(name = "subtask_id")
    private Int subtaskId;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Builder
    public Issue(Int id, Int projectId, String title, Int typeId, String description,
                Int priorityId, Int statusId, Int storyPoints, Int timeEstimate, Int timeSpent,
                Int reporterId, Int ownerId, Int subtaskId, Date creationDate, Date updateDate) {
        this.id = id;
        this.projectId = projectId;
        this.title = title;
        this.typeId = typeId;
        this.description = description;
        this.priorityId = priorityId;
        this.statusId = statusId;
        this.storyPoints = storyPoints;
        this.timeEstimate = timeEstimate;
        this.timeSpent = timeSpent;
        this.reporterId = reporterId;
        this.ownerId = ownerId;
        this.subtaskId = subtaskId;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }
}
