package com.jirafake.api.dto;

import com.jirafake.api.entity.Issue;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IssueDTO {

    private Int id;

    private Int projectId;

    @NotBlank(message = "title is mandatory")
    private String title;

    private Int typeId;

    @NotBlank(message = "description is mandatory")
    private String description;

    @NotBlank(message = "priority is mandatory")
    private Int priorityId;

    private Int statusId;

    private Int storyPoints;

    private Int timeEstimate;

    private Int timeSpent;

    private Int reporterId;

    private Int ownerId;

    private Int subtaskId;

    private Date creationDate;

    private Date updateDate;

    @Builder
    public IssueDTO(Int id, Int projectId, String title, Int typeId, String description,
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
        this.creationDate = issue.getCreationDate();
        this.updateDate = issue.getUpdateDate();
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
        .creationDate(creationDate)
        .updateDate(updateDate)
        .build();
    }
}
