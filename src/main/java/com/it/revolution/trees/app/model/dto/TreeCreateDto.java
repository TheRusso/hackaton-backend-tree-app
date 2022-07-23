package com.it.revolution.trees.app.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.it.revolution.trees.app.model.entity.TreeState;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TreeCreateDto {

    @JsonProperty("registerNumber")
    private String registerNumber;

    @JsonProperty("x")
    private Double x;

    @JsonProperty("y")
    private Double y;

    @JsonProperty("radius")
    private Integer radius;

    @JsonProperty("birthDate")
    private LocalDateTime birthDate;

    @JsonProperty("type")
    private Long typeId;

    @JsonProperty("state")
    private TreeState state;

    @JsonProperty("photoUrl")
    private String photoUrl;

    @JsonProperty("tasks")
    private List<TaskDto> tasks;

}
