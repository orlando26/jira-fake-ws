package com.jirafake.api.dto;

import com.jirafake.api.entity.Type;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TypeDTO {
    
    private Integer id;

    private String name;

    @Builder
    public TypeDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TypeDTO(Type type) {
        this.id = type.getId();
        this.name = type.getName();
    }

    public Type toEntity() {
        return Type.builder()
        .id(id)
        .name(name)
        .build();
    }
}
