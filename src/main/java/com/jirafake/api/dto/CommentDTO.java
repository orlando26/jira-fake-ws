package com.jirafake.api.dto;

import com.jirafake.api.entity.Comment;
import com.jirafake.api.entity.JiraFakeEntity;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CommentDTO extends JiraFakeEntity {

    private Integer id;

    @NotBlank(message = "text is mandatory")
    private String text;

    private Integer userId;

    private Integer issueId;

    @Builder
    public CommentDTO(Integer id, String text, Integer userId, Integer issueId) {
        super();
        this.id = id;
        this.text = text;
        this.userId = userId;
        this.issueId = issueId;
    }

    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.text = comment.getText();
        this.userId = comment.getUserId();
        this.issueId = comment.getIssueId();
    }

    public Comment toEntity() {
        return Comment.builder()
        .id(id)
        .text(text)
        .userId(userId)
        .issueId(issueId)
        .build();
    }
}
