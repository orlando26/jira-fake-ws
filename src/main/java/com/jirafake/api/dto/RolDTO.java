package com.jirafake.api.dto;

import com.jirafake.api.entity.Priority;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RolDTO {

    private Integer id;

    private String rol;

    @Builder
    public RolDTO(Integer id, String rol) {
        this.id = id;
        this.rol = rol;
    }

    public RolDTO(Rol rol) {
        this.id = rol.getId(id);
        this.rol = rol.getRol(rol);
    }

    public Rol toEntity() {
        return Rol.builder()
        .id(id)
        .rol(rol)
        .build();
    }
}
