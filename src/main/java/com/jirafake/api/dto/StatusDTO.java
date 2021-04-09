package com.jirafake.api.dto;

import com.jirafake.api.entity.Status;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StatusDTO {
    
    private Integer id;
    private String name;
    private Integer projectId;
    private Boolean doneStatus;

    @Builder
    public StatusDTO(Integer id, String name, Integer projectId, Boolean doneStatus) {
        this.id = id;
        this.name = name;
        this.projectId = projectId;
        this.doneStatus = doneStatus;
    }

    public StatusDTO(Status status) {
        this.id = status.getId();
        this.name = status.getName();
        this.projectId = status.getProjectId();
        this.doneStatus = status.getDoneStatus();
    }

    public Status toEntity() {
        return Status.builder()
        .id(id)
        .name(name)
        .projectId(projectId)
        .doneStatus(doneStatus)
        .build();
    }
}
