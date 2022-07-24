package com.it.revolution.trees.app.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.it.revolution.trees.app.model.entity.TreeTaskStatus;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class TaskDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("tree_id")
    private Long treeId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("expectedExecutionTime")
    private Integer expectedExecutionTime;

    @JsonProperty("status")
    private TreeTaskStatus status;

    @JsonProperty("endDate")
    private Date endDate;

}
