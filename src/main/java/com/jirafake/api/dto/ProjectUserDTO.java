package com.jirafake.api.dto;

import com.jirafake.api.entity.ProjectUser;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectUserDTO {

    private Integer id;

    private String projectId;
    
    private String userId;

    @Builder
    public ProjectUserDTO(Integer id, String projectId, String userId) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
    }

    public ProjectUserDTO(ProjectUser projectUser) {
        this.id = projectUser.getId();
        this.projectId = projectUser.getProjectId();
        this.userId = projectUser.getUserId();
    }

    public ProjectUser toEntity() {
        return ProjectUser.builder()
        .id(id)
        .projectId(projectId)
        .userId(userId)
        .build();
    }
}
