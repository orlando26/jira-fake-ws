package com.jirafake.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.validator.constraints.NotBlank;

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
	@Column(name = "id")
    private Integer id;

    @Column(name = "rol")
    private String rol;

    @Builder
    public Rol(Integer id, String rol) {
        this.id = id;
        this.rol = rol;
    }



}
