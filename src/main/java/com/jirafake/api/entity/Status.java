package com.jirafake.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "status")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Status extends JiraFakeEntity{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "done_status", columnDefinition = "TINYINT(1)")
    private Boolean doneStatus;

    @Builder
	public Status(Integer id, String name, Integer projectId, Boolean doneStatus) {
        super();
		this.id = id;
		this.name = name;
		this.projectId = projectId;
		this.doneStatus = doneStatus;
	}
}
