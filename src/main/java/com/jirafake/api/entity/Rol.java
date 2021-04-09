package com.jirafake.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "rol")
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Rol {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "TINYINT(2)")
    private Integer id;

    @Column(name = "rol")
    private String rol;

    @Builder
    public Rol(Integer id, String rol) {
        this.id = id;
        this.rol = rol;
    }



}
