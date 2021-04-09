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
@Entity(name = "comments")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Comment extends JiraFakeEntity {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private Integer id;

    @Column
    private String text;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "issue_id")
    private Integer issueId;

    @Builder
    public Comment(Integer id, String text, Integer userId, Integer issueId) {
        super();
        this.id = id;
        this.text = text;
        this.userId = userId;
        this.issueId = issueId;
    }
}
