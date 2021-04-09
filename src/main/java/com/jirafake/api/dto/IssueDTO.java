package com.jirafake.api.dto;

import com.jirafake.api.entity.Issue;
import com.jirafake.api.entity.JiraFakeEntity;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class IssueDTO extends JiraFakeEntity {

    private Integer id;

    private Integer projectId;

    @NotBlank(message = "title is mandatory")
    private String title;

    private Integer typeId;

    @NotBlank(message = "description is mandatory")
    private String description;

    @NotBlank(message = "priority is mandatory")
    private Integer priorityId;

    private Integer statusId;

    private Integer storyPoints;

    private Integer timeEstimate;

    private Integer timeSpent;

    private Integer reporterId;

    private Integer ownerId;

    private Integer subtaskId;

    @Builder
    public IssueDTO(Int id, Integer projectId, String title, Integer typeId, String description,
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

    public IssueDTO(Issue issue) {
        this.id = issue.getId();
        this.projectId = issue.getProjectId();
        this.title = issue.getTitle();
        this.typeId = issue.getTypeId();
        this.description = issue.getDescription();
        this.priorityId = issue.getPriorityId();
        this.statusId = issue.getStatusId();
        this.storyPoints = issue.getStoryPoints();
        this.timeEstimate = issue.getTimeEstimate();
        this.timeSpent = issue.getTimeSpent();
        this.reporterId = issue.getReporterId();
        this.ownerId = issue.getOwnerId();
        this.subtaskId = issue.getSubtaskId();
    }

    public Issue toEntity() {
        return Issue.builder()
        .id(id)
        .projectId(projectId)
        .title(title)
        .typeId(typeId)
        .description(description)
        .priorityId(priorityId)
        .statusId(statusId)
        .storyPoints(storyPoints)
        .timeEstimate(timeEstimate)
        .timeSpent(timeSpent)
        .reporterId(reporterId)
        .ownerId(ownerId)
        .subtaskId(subtaskId)
        .build();
    }
}
