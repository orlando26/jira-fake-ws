package com.jirafake.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "user")
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String lastname;

    @Column
    private String email;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "rol_id")
    private Int rolId;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Builder
    public User(Integer id, String username, String password, String name, String lastname,
                String email, String avatarUrl, Int rolId, Date creationDate, Date updateDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.rolId = rolId;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }
}
