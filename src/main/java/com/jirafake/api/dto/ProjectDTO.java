package com.jirafake.api.dto;

import com.jirafake.api.entity.Project;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectDTO {
    
    private Integer id;
    private String name;
    private String description;

    @Builder
    public ProjectDTO(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ProjectDTO(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.description = project.getDescription();
    }

    public Project toEntity() {
        return Project.builder()
        .id(id)
        .name(name)
        .description(description)
        .build();
    }
}
