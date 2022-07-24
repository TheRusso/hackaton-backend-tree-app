package com.it.revolution.trees.app.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.it.revolution.trees.app.model.entity.TreeState;
import com.it.revolution.trees.app.model.entity.TreeType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
public class TreeDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("registrationNumber")
    private String registrationNumber;

    @JsonProperty("x")
    private Double x;

    @JsonProperty("y")
    private Double y;

    @JsonProperty("radius")
    private Integer radius;

    @JsonProperty("birthDate")
    private LocalDateTime birthDate;

    @JsonProperty("type")
    private TreeTypeDto type;

    @JsonProperty("state")
    private TreeState state;

    @JsonProperty("photoUrl")
    private String photoUrl;

    @JsonProperty("tasks")
    private List<TaskDto> tasks;

}
