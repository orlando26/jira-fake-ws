package com.jirafake.api.dto;

import com.jirafake.api.entity.SprintIssue;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SprintIssueDTO {

    private Integer id;

    private Integer sprintId;

    private Integer issueId;

    @Builder
    public SprintIssueDTO(Integer id, Integer sprintId, Integer issueId) {
        this.id = id;
        this.sprintId = sprintId;
        this.issueId = issueId;
    }

    public SprintIssueDTO(SprintIssue sprintIssue) {
        this.id = sprintIssue.getId();
        this.sprintId = sprintIssue.getSprintId();
        this.issueId = sprintIssue.getIssueId();
    }

    public SprintIssue toEntity() {
        return SprintIssue.builder()
        .id(id)
        .sprintId(sprintId)
        .issueId(issueId)
        .build();
    }
}
