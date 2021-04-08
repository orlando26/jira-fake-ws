package com.jirafake.api.dto;

import com.jirafake.api.entity.User;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    private Integer id;

    @NotBlank(message = "username is mandatory")
    private String username;

    @NotBlank(message = "password is mandatory")
    private String password;

    @NotBlank(message = "name is mandatory")
    private String name;

    @NotBlank(message = "lastname is mandatory")
    private String lastname;

    @NotBlank(message = "email is mandatory")
    private String email;

    private String avatarUrl;

    private Int rolId;

    private Date creationDate;

    private Date updateDate;

    @Builder
    public UserDTO(Integer id, String username, String password, String name, String lastname,
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

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.name = user.getName();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.avatarUrl = user.getAvatarUrl();
        this.rolId = user.getRolId();
        this.creationDate = user.getCreationDate();
        this.updateDate = user.getUpdateDate();
    }

    public User toEntity() {
        return User.builder()
        .id(id)
        .username(username)
        .password(password)
        .name(name)
        .lastname(lastname)
        .email(email)
        .avatarUrl(avatarUrl)
        .rolId(rolId)
        .creationDate(creationDate)
        .updateDate(updateDate)
        .build();
    }
}
