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
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "user")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User extends JiraFakeEntity{

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

    @Column(name = "rol_id", columnDefinition = "TINYINT(2)")
    private Integer rolId;

    @Builder
    public User(Integer id, String username, String password, String name, String lastname,
                String email, String avatarUrl, Integer rolId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.rolId = rolId;
    }
}
