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
@Entity(name = "comments")
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Comment {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private Integer id;

    @Column
    private String text;

    @Column(name = "user_id")
    private Int userId;

    @Column(name = "issue_id")
    private Int issueId;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Builder
    public Comment(Integer id, String text, Int userId, Int issueId, Date creationDate, Date updateDate) {
        this.id = id;
        this.text = text;
        this.userId = userId;
        this.issueId = issueId;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }
}
