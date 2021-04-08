package com.jirafake.api.dto;

import com.jirafake.api.entity.Comment;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDTO {
    
    private Integer id;
    
    @NotBlank(message = "text is mandatory")
    private String text;
    
    private Int userId;
    
    private Int issueId;
    
    private Date creationDate;
    
    private Date updateDate;

    @Builder
    public CommentDTO(Integer id, String text, Int userId, Int issueId,
                      Date creationDate, Date updateDate) {
        this.id = id;
        this.text = text;
        this.userId = userId;
        this.issueId = issueId;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public CommentDTO(Comment comment) {
        this.id = coment.getId();
        this.text = coment.getText();
        this.userId = coment.getUserId();
        this.issueId = coment.getIssueId();
        this.creationDate = coment.getCreationDate();
        this.updateDate = coment.getUpdateDate();
    }

    public Comment toEntity() {
        return Comment.builder()
        .id(id)
        .text(text)
        .userId(userId)
        .issueId(issueId)
        .creationDate(creationDate)
        .updateDate(updateDate)
        .build();
    }
}
