package com.jirafake.api.dto;

import com.jirafake.api.entity.Priority;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PriorityDTO {
    
    private Integer id;

    private String name;

    @Builder
    public PriorityDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public PriorityDTO(Priority priority) {
        this.id = priority.getId();
        this.name = priority.getName();
    }

    public Priority toEntity() {
        return Priority.builder()
        .id(id)
        .name(name)
        .build();
    }
}
