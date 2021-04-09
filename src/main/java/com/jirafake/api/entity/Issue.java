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
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "issue")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Issue extends JiraFakeEntity {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;

    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "title")
    private String title;

    @Column(name = "type_id", columnDefinition = "TINYINT(2)")
    private Integer typeId;

    @Column(name = "description")
    private String description;

    @Column(name = "priority_id", columnDefinition = "TINYINT(2)")
    private Integer priorityId;

    @Column(name = "status_id", columnDefinition = "TINYINT(2)")
    private Integer statusId;

    @Column(name = "story_points")
    private Integer storyPoints;

    @Column(name = "time_estimate")
    private Integer timeEstimate;

    @Column(name = "time_spent")
    private Integer timeSpent;

    @Column(name = "reporter_id")
    private Integer reporterId;

    @Column(name = "owner_id")
    private Integer ownerId;

    @Column(name = "subtask_id")
    private Integer subtaskId;

    @Builder
    public Issue(Int id, Integer projectId, String title, Integer typeId, String description,
                Integer priorityId, Integer statusId, Integer storyPoints, Integer timeEstimate, Integer timeSpent,
                Integer reporterId, Integer ownerId, Integer subtaskId) {
        super();
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
    }
}
